
.include "stm32l476_msp_stk_h.s"

.data
uwTick: 	.word 		0
msTick:		.word		0

.section .text.SysTick_Config
.type	SysTick_Config,%function
SysTick_Config:
// Set SysTick_CTRL to disabLe SysTick IRQ and SysTick timer
	ldr r0, =SysTick_BASE

	// DisabLe SysTick IRQ and SysTick counter, select external clock
	//mov r1, #0
	str r1, [r0, #SysTick_CTRL]

	// Specify the number of cLock cycles between two interrupts
	ldr r2, =3999 // Change it based on interrupt interval
	str r2, [r0, #SysTick_LOAD] // Save to SysTick reload register

	// Clear SysTick current value register (SysTick_VAL)
	mov r1, #0
	str r1, [r0, #SysTick_VAL] // Write e to SysTick value register

	// Set interrupt priority for SysTick
	ldr r2, =SCB_BASE
	add r2, r2,#SCB_SHP
	ldr r1, =0xf0000000	// Set priority as 1, see Figure 11-7
	str r1, [r2]	// SCB->SHP[ll), see Figure 11 -8

	// Set SysTick_CTRL to enable SysTick timer and SysTick interrupt
	LDR r1, [r0, #SysTick_CTRL]
	MOV r2,#0X00000007
	ORR r1,r1,r2  // Enable SysTick counter & interrupt
	STR r1, [r0, #SysTick_CTRL]

	bx lr
.size	SysTick_Config, .-SysTick_Config

.section	.text.SysTick_Handler
.type	SysTick_Handler,%function
SysTick_Handler:
	push {lr}
	ldr r0,=uwTick
	ldr r1,[r0]
	add r1,#1
	str r1,[r0]
	pop {pc}
	//bx lr
.size SysTick_Handler, .-SysTick_Handler

.section	.text.GetTick
.type	GetTick,%function
GetTick:
	ldr r0,=uwTick
	ldr r0,[r0]
	bx lr
.size GetTick, .-GetTick


.section	.text.Delay
.type	Delay,%function
Delay:
// delay1:
delay1:
	sub r0,#1
	cbz r0,enddelay1
	b delay1
enddelay1:
	bx lr
.size Delay, .-Delay


.section .text.STK_Config_Polling
.type STK_Config_Polling,%function
STK_Config_Polling:
// SysTick configuration PM0214 Sec. 4.5 SysTick timer (STK) pg. 246
	ldr r0,=RCC_BASE
	movw r1,0x1
	movt r1,0
	// RCC_APB2ENR, SYSCFGEN, RM0351 Pg. 259
	ldr r2, [r0,RCC_APB2ENR]    // Read its content to r5
	orr r2, r1                 	// Set   bit 0 to enable SYSCFG clock
	str r2, [r0,RCC_APB2ENR]    // Store result in peripheral clock register

	// Set SysTick_CTRL to disabLe SysTick IRQ and SysTick timer
	ldr r0, =SysTick_BASE

	// Specify the number of cLock cycles between two interrupts
	ldr r2, =3999 // Change it based on interrupt interval
	str r2, [r0, #SysTick_LOAD] // Save to SysTick reload register

	// Clear SysTick current value register (SysTick_VAL)
	mov r1, #0
	str r1, [r0, #SysTick_VAL] // Write e to SysTick value register

	// Set SysTick_CTRL to enable SysTick timer and SysTick interrupt
	ldr r1, [r0, #SysTick_CTRL]
	mov r2,#0x00000005
	orr r1,r1,r2  // Enable SysTick counter & interrupt
	str r1, [r0, #SysTick_CTRL]
	bx lr
.size STK_Config_Polling,.-STK_Config_Polling

.section .text.STK_Polling
.type STK_Polling,%function
STK_Polling:
	ldr r4, =SysTick_BASE
	ldr r5, [r4, #SysTick_CTRL]
	and r5,(1<<16)
	cbz r5,endgettickpolling
	ldr r6,=msTick
	ldr r7,[r6]
	add r7,1
	str r7,[r6]

endgettickpolling:
	bx lr
.size	STK_Polling,.-STK_Polling

.section	.text.STK_Get_msTick
.type	STK_Get_msTick,%function
STK_Get_msTick:
	ldr r0,=msTick
	ldr r0,[r0]
	bx lr
.size STK_Get_msTick, .-STK_Get_msTick
