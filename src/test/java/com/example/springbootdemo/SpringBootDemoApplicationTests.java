package com.example.springbootdemo;

import com.example.springbootdemo.dto.*;
import com.fasterxml.jackson.databind.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.result.*;
import org.springframework.transaction.annotation.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class SpringBootDemoApplicationTests {

    // APIを発行するためのMockオブジェクトを生成
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHello() throws Exception {
        // 検証するAPIパス
        final String API_PATH = "/hello";

        // JavaのObjectをJSONに変換するためのクラスを生成
        ObjectMapper objectMapper = new ObjectMapper();

        // 結果を検証するためのクラスを生成して、期待値をセット
        Sample sample = new Sample();
        sample.setId(100);
        sample.setName("taro");

        // 「/hello」パスのAPIを実行してレスポンスを検証
        this.mockMvc.perform(MockMvcRequestBuilders.get(API_PATH))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(content().json(objectMapper.writeValueAsString(sample)));
    }

    @Test
    void testGetItemById() throws Exception {

        //検証するパス
        final String API_PATH = "/items/1";

        ObjectMapper objectMapper = new ObjectMapper();

        ItemResponse itemResponse = new ItemResponse();
        itemResponse.setId(1);
        itemResponse.setItemName("大豆");

        //APIを実行してレスポンスで検証
        this.mockMvc.perform(MockMvcRequestBuilders.get(API_PATH))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andExpect(content().json(objectMapper.writeValueAsString(itemResponse)));
    }
}
