
#intel表記を使う
.intel_syntax noprefix

#エントリポイント
.global _start
_start:
lea rdi,[.s1]
call printf

#exit(0)で終了
end:
mov rdi,0
call exit

#文字列リテラル.s連番で定義
.s1: .string "hello world"
