
#intel�\�L���g��
.intel_syntax noprefix

#�G���g���|�C���g
.global _start
_start:
lea rdi,[.s1]
call printf

#exit(0)�ŏI��
end:
mov rdi,0
call exit

#�����񃊃e����.s�A�ԂŒ�`
.s1: .string "hello world"
