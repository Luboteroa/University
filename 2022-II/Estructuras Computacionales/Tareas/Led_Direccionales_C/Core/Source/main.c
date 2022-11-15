/**
 ******************************************************************************
 * @file           : main.c
 * @author         : Auto-generated by STM32CubeIDE
 * @brief          : Main program body
 ******************************************************************************
 * @attention
 *
 * Copyright (c) 2022 STMicroelectronics.
 * All rights reserved.
 *
 * This software is licensed under terms that can be found in the LICENSE file
 * in the root directory of this software component.
 * If no LICENSE file comes with this software, it is provided AS-IS.
 *
 ******************************************************************************
 */
#include "main.h"

uint8_t Button = 0;



extern void FSM_LD2_Blink(void);
extern void FSM_Read_PushButton(uint8_t *flag2, uint8_t *flag, uint8_t *flag3);
extern void DireccionalDerecha(uint8_t *flag2, uint8_t *flag, uint8_t *flag3);
extern void FSM_Read_PushButton2(uint8_t *flag2, uint8_t *flag, uint8_t *flag3);
extern void FSM_Read_PushButton3(uint8_t *flag2, uint8_t *flag, uint8_t *flag3);
extern void DireccionalIzquierda(uint8_t *flag2, uint8_t *flag, uint8_t *flag3);
extern void Stop(uint8_t *flag2, uint8_t *flag, uint8_t *flag3);
static uint8_t temp = 0;
static uint8_t temp2 = 0;
static uint8_t temp3 = 0;

int main(void)
{

	HAL_NUCLEO_L476_INIT();
	/* Loop forever */
	for(;;){
		//FSM_LD2_Blink();
		//Button1 = LL_GPIO_ReadInputPort(GPIOA);
		//S1 = 48
		//S2 = 34
		//NO PRE = 50
		FSM_Read_PushButton(&temp,&temp2,&temp3);
		FSM_Read_PushButton2(&temp,&temp2,&temp3);
		FSM_Read_PushButton3(&temp,&temp2,&temp3);
		DireccionalDerecha(&temp,&temp2,&temp3);
		DireccionalIzquierda(&temp,&temp2,&temp3);
		Stop(&temp,&temp2,&temp3);
	}
}






