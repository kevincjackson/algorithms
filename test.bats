#!/usr/bin/env bats

@test "hello world" {
  [ `echo hi` = "hi" ]
}
