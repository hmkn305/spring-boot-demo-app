#!/bin/sh

GENERAL_LOG=/var/log/general_log
cp /dev/null $GENERAL_LOG
chown mysql:mysql $GENERAL_LOG
chmod 644 $GENERAL_LOG
tail -f $GENERAL_LOG 1>&2 & docker-entrypoint.sh mysqld --general_log --general_log_file=$GENERAL_LOG \
--character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci