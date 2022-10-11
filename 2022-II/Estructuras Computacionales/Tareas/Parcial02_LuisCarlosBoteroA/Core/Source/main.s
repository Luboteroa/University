/*
 * main.s
 *
 *  Created on: Sep 19, 2022
 *      Author: gosor
 */

.include "main_h.s"

.data


b1_pushed:     .word    0
s1_pushed:     .word    0
s2_pushed:     .word    0
s3_pushed:     .word    0


b1_state:	   .word    0
b1_flag:	   .word    0
s1_state:	   .word    0
s1_flag:	   .word    0
s2_state:	   .word    0
s2_flag:	   .word    0
s3_state:	   .word    0
s3_flag:	   .word    0

last_tick_d4_blink: 		.word 	0
last_tick_turn_left:		.word 	0
last_tick_turn_right:		.word 	0
last_tick_stop:				.word 	0

tl_state: 	.word 	0
tr_state: 	.word 	0
s_state: 	.word 	0


.section .text.main
.type main,%function
main:
	bl STK_Config_Polling

	// bl LD2_Init
	// bl B1_Init
	bl MFShield_Sx_Init
	bl MFShield_Dx_Init
	bl BB_Lx_Init

	bl BB_L0_Set
	bl BB_L1_Set
	bl BB_L2_Set
	bl BB_L3_Set
	bl BB_L4_Set
	bl BB_L5_Set
	bl BB_L6_Set
	bl BB_L7_Set

	bl BB_L0_Clear
	bl BB_L1_Clear
	bl BB_L2_Clear
	bl BB_L3_Clear
	bl BB_L4_Clear
	bl BB_L5_Clear
	bl BB_L6_Clear
	bl BB_L7_Clear
	// bl LD2_Set
loop:

	bl STK_Polling

	bl Update_Inputs

//	bl FSM_b1_state
	bl FSM_s1_state
	bl FSM_s2_state
	bl FSM_s3_state

//	bl Update_LD2
	bl Update_D1
	bl Update_D2
	bl Update_D3

	bl STK_Get_msTick
	movw r1,500
	bl FSM_D4_Blink



	bl STK_Get_msTick
	movw r1,100
	bl FSM_Turn_Left

	bl STK_Get_msTick
	movw r1,500
	bl FSM_Stop

	bl STK_Get_msTick
	movw r1,100
	bl FSM_Turn_Right


	b loop

.size main,.-main


.section .text.FSM_Turn_Left
.type	FSM_Turn_Left,%function
FSM_Turn_Left:
	push {lr}

	mov r4,r0
	ldr r5,=last_tick_turn_left
	ldr r5,[r5]
	sub r4,r5
	cmp r4,r1
	blt tl_end_case

	ldr r1,=last_tick_turn_left
    str r0,[r1]

	ldr r0,=tl_state
	ldr r1,[r0]
	cmp	r1,0
	beq tl_state_0
	cmp	r1,1
	beq tl_state_1
	cmp	r1,2
	beq tl_state_2
	cmp	r1,3
	beq tl_state_3
	cmp	r1,4
	beq tl_state_4
	cmp	r1,5
	beq tl_state_5
	cmp	r1,6
	beq tl_state_6
	cmp	r1,7
	beq tl_state_7
	cmp	r1,8
	beq tl_state_8
	b tl_end_case

tl_state_0:
	ldr r2,=s1_flag
	ldr r3,[r2]
	cmp r3,0
	beq tl_end_case
	bl BB_L0_Set
	ldr r4,=tl_state
	mov r5,1
	str r5,[r4]
	b tl_end_case

tl_state_1:
	bl BB_L1_Set
	ldr r4,=tl_state
	mov r5,2
	str r5,[r4]
	b tl_end_case


tl_state_2:
	bl BB_L2_Set
	ldr r4,=tl_state
	mov r5,3
	str r5,[r4]
	b tl_end_case


tl_state_3:
	bl BB_L3_Set
	ldr r4,=tl_state
	mov r5,4
	str r5,[r4]
	b tl_end_case


tl_state_4:
	bl BB_L4_Set
	ldr r4,=tl_state
	mov r5,5
	str r5,[r4]
	b tl_end_case

tl_state_5:
	bl BB_L5_Set
	ldr r4,=tl_state
	mov r5,6
	str r5,[r4]
	b tl_end_case

tl_state_6:
	bl BB_L6_Set
	ldr r4,=tl_state
	mov r5,7
	str r5,[r4]
	b tl_end_case


tl_state_7:
	bl BB_L7_Set
	ldr r4,=tl_state
	mov r5,8
	str r5,[r4]
	b tl_end_case


tl_state_8:
	bl BB_L0_Clear
	bl BB_L1_Clear
	bl BB_L2_Clear
	bl BB_L3_Clear
	bl BB_L4_Clear
	bl BB_L5_Clear
	bl BB_L6_Clear
	bl BB_L7_Clear

	ldr r4,=tl_state
	mov r5,0
	str r5,[r4]

tl_end_case:

	pop {pc}
.size FSM_D4_Blink,.-FSM_D4_Blink


.section .text.FSM_Turn_Right
.type	FSM_Turn_Right,%function
FSM_Turn_Right:
	push {lr}

	mov r4,r0
	ldr r5,=last_tick_turn_right
	ldr r5,[r5]
	sub r4,r5
	cmp r4,r1
	blt tr_end_case

	ldr r1,=last_tick_turn_right
    str r0,[r1]

ldr r0,=tr_state
	ldr r1,[r0]
	cmp	r1,0
	beq tr_state_0
	cmp	r1,1
	beq tr_state_1
	cmp	r1,2
	beq tr_state_2
	cmp	r1,3
	beq tr_state_3
	cmp	r1,4
	beq tr_state_4
	cmp	r1,5
	beq tr_state_5
	cmp	r1,6
	beq tr_state_6
	cmp	r1,7
	beq tr_state_7
	cmp	r1,8
	beq tr_state_8
	b tr_end_case

tr_state_0:
	ldr r2,=s3_flag
	ldr r3,[r2]
	cmp r3,0
	beq tr_end_case
	bl BB_L7_Set
	ldr r4,=tr_state
	mov r5,1
	str r5,[r4]
	b tr_end_case

tr_state_1:
	bl BB_L6_Set
	ldr r4,=tr_state
	mov r5,2
	str r5,[r4]
	b tr_end_case


tr_state_2:
	bl BB_L5_Set
	ldr r4,=tr_state
	mov r5,3
	str r5,[r4]
	b tr_end_case


tr_state_3:
	bl BB_L4_Set
	ldr r4,=tr_state
	mov r5,4
	str r5,[r4]
	b tr_end_case


tr_state_4:
	bl BB_L3_Set
	ldr r4,=tr_state
	mov r5,5
	str r5,[r4]
	b tr_end_case

tr_state_5:
	bl BB_L2_Set
	ldr r4,=tr_state
	mov r5,6
	str r5,[r4]
	b tr_end_case

tr_state_6:
	bl BB_L1_Set
	ldr r4,=tr_state
	mov r5,7
	str r5,[r4]
	b tr_end_case


tr_state_7:
	bl BB_L0_Set
	ldr r4,=tr_state
	mov r5,8
	str r5,[r4]
	b tr_end_case


tr_state_8:
	bl BB_L0_Clear
	bl BB_L1_Clear
	bl BB_L2_Clear
	bl BB_L3_Clear
	bl BB_L4_Clear
	bl BB_L5_Clear
	bl BB_L6_Clear
	bl BB_L7_Clear

	ldr r4,=tr_state
	mov r5,0
	str r5,[r4]

tr_end_case:

	pop {pc}
.size FSM_D4_Blink,.-FSM_D4_Blink


.section .text.FSM_Stop
.type	FSM_Stop,%function
FSM_Stop:
	push {lr}

	mov r4,r0
	ldr r5,=last_tick_stop
	ldr r5,[r5]
	sub r4,r5
	cmp r4,r1
	blt s_end_case

	ldr r1,=last_tick_stop
    str r0,[r1]

    ldr r0,=s_state
	ldr r1,[r0]
	cmp	r1,0
	beq s_state_0
	cmp	r1,1
	beq s_state_1

	b s_end_case

s_state_0:
	ldr r2,=s2_flag
	ldr r3,[r2]
	cmp r3,0
	beq s_end_case
	bl BB_L0_Set
	bl BB_L1_Set
	bl BB_L2_Set
	bl BB_L3_Set
	bl BB_L4_Set
	bl BB_L5_Set
	bl BB_L6_Set
	bl BB_L7_Set
	ldr r4,=s_state
	mov r5,1
	str r5,[r4]
	b s_end_case

s_state_1:
	bl BB_L0_Clear
	bl BB_L1_Clear
	bl BB_L2_Clear
	bl BB_L3_Clear
	bl BB_L4_Clear
	bl BB_L5_Clear
	bl BB_L6_Clear
	bl BB_L7_Clear
	ldr r4,=s_state
	mov r5,0
	str r5,[r4]


s_end_case:
	pop {pc}
.size FSM_D4_Blink,.-FSM_D4_Blink


.section .text.FSM_D4_Blink
.type	FSM_D4_Blink,%function
FSM_D4_Blink:
	push {lr}

	mov r4,r0
	ldr r5,=last_tick_d4_blink
	ldr r5,[r5]
	sub r4,r5
	cmp r4,r1
	blt endledtoggle

	ldr r1,=last_tick_d4_blink
    str r0,[r1]
	ldr r0,=GPIOB_BASE
	movw r1,(1<<6)
	movt r1,0

	bl GPIO_Toggle

endledtoggle:

	pop {pc}
.size FSM_D4_Blink,.-FSM_D4_Blink




.section .text.FSM_b1_state
.type	FSM_b1_state,%function
FSM_b1_state:
// begin_case_b1_state

	ldr r0,=b1_state
	ldr r1,[r0]
	cmp	r1,0
	beq b1_state_0
	cmp r1,1
	beq b1_state_1
	b end_case_b1_state

b1_state_0:
	ldr r2,=b1_pushed
	ldr r3,[r2]
	cmp r3,0
	beq end_b1_state_0
	mov r4,1
	str r4,[r0]
end_b1_state_0:

	b end_case_b1_state

b1_state_1:
	ldr r2,=b1_pushed
	ldr r3,[r2]
	cmp r3,1
	beq end_case_b1_state
	mov r4,0
	str r4,[r0]
	ldr r1,=b1_flag
	ldr r2,[r1]
	eor r2,1
	str r2,[r1]
end_case_b1_state:
// end_case_b1_state
	bx lr
.size FSM_b1_state,.-FSM_b1_state





.section .text.FSM_s1_state
.type	FSM_s1_state,%function
FSM_s1_state:
// begin_case_b1_state

	ldr r0,=s1_state
	ldr r1,[r0]
	cmp	r1,0
	beq s1_state_0
	cmp r1,1
	beq s1_state_1
	b end_case_s1_state

s1_state_0:
	ldr r2,=s1_pushed
	ldr r3,[r2]
	cmp r3,0
	beq end_s1_state_0
	mov r4,1
	str r4,[r0]
end_s1_state_0:

	b end_case_s1_state

s1_state_1:
	ldr r2,=s1_pushed
	ldr r3,[r2]
	cmp r3,1
	beq end_case_s1_state
	mov r4,0
	str r4,[r0]
	ldr r1,=s1_flag
	ldr r2,[r1]
	eor r2,1
	str r2,[r1]
end_case_s1_state:
// end_case_b1_state
	bx lr
.size FSM_s1_state,.-FSM_s1_state



.section .text.FSM_s2_state
.type	FSM_s2_state,%function
FSM_s2_state:
// begin_case_s2_state

	ldr r0,=s2_state
	ldr r1,[r0]
	cmp	r1,0
	beq s2_state_0
	cmp r1,1
	beq s2_state_1
	b end_case_s2_state

s2_state_0:
	ldr r2,=s2_pushed
	ldr r3,[r2]
	cmp r3,0
	beq end_s2_state_0
	mov r4,1
	str r4,[r0]
end_s2_state_0:

	b end_case_s2_state

s2_state_1:
	ldr r2,=s2_pushed
	ldr r3,[r2]
	cmp r3,1
	beq end_case_s2_state
	mov r4,0
	str r4,[r0]
	ldr r1,=s2_flag
	ldr r2,[r1]
	eor r2,1
	str r2,[r1]
end_case_s2_state:
// end_case_s2_state
	bx lr
.size FSM_s2_state,.-FSM_s2_state

.section .text.FSM_s3_state
.type	FSM_s3_state,%function
FSM_s3_state:
// begin_case_s3_state

	ldr r0,=s3_state
	ldr r1,[r0]
	cmp	r1,0
	beq s3_state_0
	cmp r1,1
	beq s3_state_1
	b end_case_s3_state

s3_state_0:
	ldr r2,=s3_pushed
	ldr r3,[r2]
	cmp r3,0
	beq end_s3_state_0
	mov r4,1
	str r4,[r0]
end_s3_state_0:

	b end_case_s3_state

s3_state_1:
	ldr r2,=s3_pushed
	ldr r3,[r2]
	cmp r3,1
	beq end_case_s3_state
	mov r4,0
	str r4,[r0]
	ldr r1,=s3_flag
	ldr r2,[r1]
	eor r2,1
	str r2,[r1]
end_case_s3_state:
// end_case_s3_state
	bx lr
.size FSM_s3_state,.-FSM_s3_state


.section .text.Update_LD2
.type	Update_LD2,%function
Update_LD2:
	push {lr}
	// Begin Led control
	ldr r0,=b1_flag
	ldr r1,[r0]
	cmp r1,0
	beq b1_flag_0
	cmp r1,1
	beq b1_flag_1
	b end_led_control

b1_flag_0:
	bl LD2_Clear
	b end_led_control

b1_flag_1:
	bl LD2_Set

end_led_control:
// End Led Control
	pop {pc}
.size Update_LD2,.-Update_LD2



.section .text.Update_D1
.type	Update_D1,%function
Update_D1:
	push {lr}
	// Begin Led control
	ldr r0,=s1_flag
	ldr r1,[r0]
	cmp r1,0
	beq s1_flag_0
	cmp r1,1
	beq s1_flag_1
	b end_d1_control

s1_flag_0:
	bl D1_Clear
	b end_d1_control

s1_flag_1:
	bl D1_Set

end_d1_control:
// End Led Control
	pop {pc}
.size Update_D1,.-Update_D1

.section .text.Update_D2
.type	Update_D2,%function
Update_D2:
	push {lr}
	// Begin Led control
	ldr r0,=s2_flag
	ldr r1,[r0]
	cmp r1,0
	beq s2_flag_0
	cmp r1,1
	beq s2_flag_1
	b end_d2_control

s2_flag_0:
	bl D2_Clear
	b end_d2_control

s2_flag_1:
	bl D2_Set

end_d2_control:
// End Led Control
	pop {pc}
.size Update_D2,.-Update_D2

.section .text.Update_D3
.type	Update_D3,%function
Update_D3:
	push {lr}
	// Begin Led control
	ldr r0,=s3_flag
	ldr r1,[r0]
	cmp r1,0
	beq s3_flag_0
	cmp r1,1
	beq s3_flag_1
	b end_d3_control

s3_flag_0:
	bl D3_Clear
	b end_d3_control

s3_flag_1:
	bl D3_Set

end_d3_control:
// End Led Control
	pop {pc}
.size Update_D3,.-Update_D3


.section .text.Update_Inputs
.type Update_Inputs,%function
Update_Inputs:
	push {lr}

	ldr r0,=GPIOC_BASE
	movw r1,(1<<13)
	ldr r2,=b1_pushed
	bl PB_Read

	ldr r0,=GPIOA_BASE
	movw r1,(1<<1)
	ldr r2,=s1_pushed
	bl PB_Read

	ldr r0,=GPIOA_BASE
	movw r1,(1<<4)
	ldr r2,=s2_pushed
	bl PB_Read

	ldr r0,=GPIOB_BASE
	movw r1,(1<<0)
	ldr r2,=s3_pushed
	bl PB_Read

	pop {pc}
.size Update_Inputs,.-Update_Inputs



.section .text.MFShield_Sx_Init
.type MFShield_Sx_Init,%function
MFShield_Sx_Init:
	push {lr}
	ldr r0,=RCC_BASE
	movw r1,3
	bl RCC_AHB2ENR_Init


	ldr r0,=GPIOA_BASE
	movw r1,0
	movt r1,0
	movw r2,0b0000001100001100
	movt r2,0
	bl GPIO_MODER_Init

	ldr r0,=GPIOB_BASE
	movw r1,0
	movt r1,0
	movw r2,0b0000000000000011
	movt r2,0
	bl GPIO_MODER_Init


	pop {pc}
.size MFShield_Sx_Init,.-MFShield_Sx_Init

.section .text.MFShield_Dx_Init
.type MFShield_Dx_Init,%function
MFShield_Dx_Init:
	push {lr}

	ldr r0,=RCC_BASE
	movw r1,1
	bl RCC_AHB2ENR_Init

	ldr r0,=GPIOA_BASE
	movw r1,(1<<10)
	movw r2,(1<<11)
	bl GPIO_MODER_Init

	ldr r0,=GPIOA_BASE
	movw r1,0
	movw r2,(1<<5)
	bl GPIO_OTYPER_Init

	ldr r0,=GPIOA_BASE
	movw r1,(1<<10)
	movw r2,(1<<11)
	bl GPIO_PUPDR_Init

	ldr r0,=GPIOA_BASE
	movw r1,(1<<12)
	movw r2,(1<<13)
	bl GPIO_MODER_Init

	ldr r0,=GPIOA_BASE
	movw r1,(1<<14)
	movw r2,(1<<15)
	bl GPIO_MODER_Init

	ldr r0,=GPIOB_BASE
	movw r1,(1<<12)
	movw r2,(1<<13)
	bl GPIO_MODER_Init

	pop {pc}
	//bx lr
.size MFShield_Dx_Init,.-MFShield_Dx_Init

.section .text.BB_Lx_Init
.type BB_Lx_Init,%function
BB_Lx_Init:
	//A:8,9 B:3,4,5,8,9,10
	push {lr}

	ldr r0,=RCC_BASE
	movw r1,0b11
	bl RCC_AHB2ENR_Init

	ldr r0,=GPIOA_BASE
	movw r1,0
	movt r1,0b0000000000000101
	movw r2,0
	movt r2,0b0000000000001010
	bl GPIO_MODER_Init

	ldr r0,=GPIOA_BASE
	movw r1,0b0000001100000000
	movw r2,0
	bl GPIO_OTYPER_Init

	ldr r0,=GPIOA_BASE
	movw r1,0
	movt r1,0b0000000000000101
	movw r2,0
	movt r2,0b0000000000001010
	bl GPIO_PUPDR_Init

	ldr r0,=GPIOB_BASE
	movw r1,0b0000010101000000
	movt r1,0b0000000000010101
	movw r2,0b0000101010000000
	movt r2,0b0000000000101010
	bl GPIO_MODER_Init

	ldr r0,=GPIOB_BASE
	movw r1,0b0000011100111000
	movw r2,0
	bl GPIO_OTYPER_Init

	ldr r0,=GPIOB_BASE
	movw r1,0b0000010101000000
	movt r1,0b0000000000010101
	movw r2,0b0000101010000000
	movt r2,0b0000000000101010
	bl GPIO_PUPDR_Init

	pop {pc}
	//bx lr
.size BB_Lx_Init,.-BB_Lx_Init

/*	ldr r0,=b1_pushed
	ldr r0,[r0]
// begin_if_ld2:
	cbz r0,ld2_off
	bl LD2_Set
	b end_if_ld2
ld2_off:
	bl LD2_Clear
end_if_ld2:*/


.section .text.D1_Set
.type D1_Set,%function
D1_Set:
	push {lr}

	ldr r0,=GPIOA_BASE
	movw r1,(1<<5)
	bl GPIO_Clear

	pop {pc}
.size D1_Set,.-D1_Set

.section .text.D1_Clear
.type D1_Clear,%function
D1_Clear:
	push {lr}

	ldr r0,=GPIOA_BASE
	movw r1,(1<<5)
	bl GPIO_Set

	pop {pc}
.size D1_Clear,.-D1_Clear

.section .text.D2_Set
.type D2_Set,%function
D2_Set:
	push {lr}

	ldr r0,=GPIOA_BASE
	movw r1,(1<<6)
	bl GPIO_Set

	pop {pc}
.size D2_Set,.-D2_Set

.section .text.D2_Clear
.type D2_Clear,%function
D2_Clear:
	push {lr}

	ldr r0,=GPIOA_BASE
	movw r1,(1<<6)
	bl GPIO_Clear

	pop {pc}
.size D2_Clear,.-D2_Clear

.section .text.D3_Set
.type D3_Set,%function
D3_Set:
	push {lr}

	ldr r0,=GPIOA_BASE
	movw r1,(1<<7)
	bl GPIO_Set

	pop {pc}
.size D3_Set,.-D3_Set

.section .text.D3_Clear
.type D3_Clear,%function
D3_Clear:
	push {lr}

	ldr r0,=GPIOA_BASE
	movw r1,(1<<7)
	bl GPIO_Clear

	pop {pc}
.size D3_Clear,.-D3_Clear


.section .text.BB_L0_Set
.type BB_L0_Set,%function
BB_L0_Set:
	push {lr}

	ldr r0,=GPIOB_BASE
	movw r1,(1<<3)
	bl GPIO_Clear

	pop {pc}
.size BB_L0_Set,.-BB_L0_Set

.section .text.BB_L0_Clear
.type BB_L0_Clear,%function
BB_L0_Clear:
	push {lr}

	ldr r0,=GPIOB_BASE
	movw r1,(1<<3)
	bl GPIO_Set

	pop {pc}
.size BB_L0_Clear,.-BB_L0_Clear

.section .text.BB_L1_Set
.type BB_L1_Set,%function
BB_L1_Set:
	push {lr}

	ldr r0,=GPIOB_BASE
	movw r1,(1<<5)
	bl GPIO_Clear

	pop {pc}
.size BB_L1_Set,.-BB_L1_Set

.section .text.BB_L1_Clear
.type BB_L1_Clear,%function
BB_L1_Clear:
	push {lr}

	ldr r0,=GPIOB_BASE
	movw r1,(1<<5)
	bl GPIO_Set

	pop {pc}
.size BB_L1_Clear,.-BB_L1_Clear

.section .text.BB_L2_Set
.type BB_L2_Set,%function
BB_L2_Set:
	push {lr}

	ldr r0,=GPIOB_BASE
	movw r1,(1<<4)
	bl GPIO_Clear

	pop {pc}
.size BB_L2_Set,.-BB_L2_Set

.section .text.BB_L2_Clear
.type BB_L2_Clear,%function
BB_L2_Clear:
	push {lr}

	ldr r0,=GPIOB_BASE
	movw r1,(1<<4)
	bl GPIO_Set

	pop {pc}
.size BB_L2_Clear,.-BB_L2_Clear

.section .text.BB_L3_Set
.type BB_L3_Set,%function
BB_L3_Set:
	push {lr}

	ldr r0,=GPIOB_BASE
	movw r1,(1<<10)
	bl GPIO_Clear

	pop {pc}
.size BB_L3_Set,.-BB_L3_Set

.section .text.BB_L3_Clear
.type BB_L3_Clear,%function
BB_L3_Clear:
	push {lr}

	ldr r0,=GPIOB_BASE
	movw r1,(1<<10)
	bl GPIO_Set

	pop {pc}
.size BB_L3_Clear,.-BB_L3_Clear

.section .text.BB_L4_Set
.type BB_L4_Set,%function
BB_L4_Set:
	push {lr}

	ldr r0,=GPIOA_BASE
	movw r1,(1<<8)
	bl GPIO_Clear

	pop {pc}
.size BB_L4_Set,.-BB_L4_Set

.section .text.BB_L4_Clear
.type BB_L4_Clear,%function
BB_L4_Clear:
	push {lr}

	ldr r0,=GPIOA_BASE
	movw r1,(1<<8)
	bl GPIO_Set

	pop {pc}
.size BB_L4_Clear,.-BB_L4_Clear

.section .text.BB_L5_Set
.type BB_L5_Set,%function
BB_L5_Set:
	push {lr}

	ldr r0,=GPIOA_BASE
	movw r1,(1<<9)
	bl GPIO_Clear

	pop {pc}
.size BB_L5_Set,.-BB_L5_Set

.section .text.BB_L5_Clear
.type BB_L5_Clear,%function
BB_L5_Clear:
	push {lr}

	ldr r0,=GPIOA_BASE
	movw r1,(1<<9)
	bl GPIO_Set

	pop {pc}
.size BB_L5_Clear,.-BB_L5_Clear

.section .text.BB_L6_Set
.type BB_L6_Set,%function
BB_L6_Set:
	push {lr}

	ldr r0,=GPIOB_BASE
	movw r1,(1<<9)
	bl GPIO_Clear

	pop {pc}
.size BB_L6_Set,.-BB_L6_Set

.section .text.BB_L6_Clear
.type BB_L6_Clear,%function
BB_L6_Clear:
	push {lr}

	ldr r0,=GPIOB_BASE
	movw r1,(1<<9)
	bl GPIO_Set

	pop {pc}
.size BB_L6_Clear,.-BB_L6_Clear

.section .text.BB_L7_Set
.type BB_L7_Set,%function
BB_L7_Set:
	push {lr}

	ldr r0,=GPIOB_BASE
	movw r1,(1<<8)
	bl GPIO_Clear

	pop {pc}
.size BB_L7_Set,.-BB_L7_Set

.section .text.BB_L7_Clear
.type BB_L7_Clear,%function
BB_L7_Clear:
	push {lr}

	ldr r0,=GPIOB_BASE
	movw r1,(1<<8)
	bl GPIO_Set

	pop {pc}
.size BB_L7_Clear,.-BB_L7_Clear




