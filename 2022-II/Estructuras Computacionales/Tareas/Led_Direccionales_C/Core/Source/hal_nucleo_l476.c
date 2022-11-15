/*
 * hal_nucleo_l476.c
 *
 *  Created on: Oct 14, 2022
 *      Author: gosor
 */

#include "hal_nucleo_l476.h"

void HAL_NUCLEO_L476_INIT(void){
	LL_Init1msTick(4000000);

	LD0_CLK_ENABLE();
	LD4_CLK_ENABLE();

	S1_CLK_ENABLE();
	S2_CLK_ENABLE();
	S3_CLK_ENABLE();

	LL_GPIO_SetPinMode(LD0_PORT, LD0, LL_GPIO_MODE_OUTPUT);
	LL_GPIO_SetPinMode(LD1_PORT, LD1, LL_GPIO_MODE_OUTPUT);
	LL_GPIO_SetPinMode(LD2_PORT, LD2, LL_GPIO_MODE_OUTPUT);
	LL_GPIO_SetPinMode(LD3_PORT, LD3, LL_GPIO_MODE_OUTPUT);
	LL_GPIO_SetPinMode(LD4_PORT, LD4, LL_GPIO_MODE_OUTPUT);
	LL_GPIO_SetPinMode(LD5_PORT, LD5, LL_GPIO_MODE_OUTPUT);
	LL_GPIO_SetPinMode(LD6_PORT, LD6, LL_GPIO_MODE_OUTPUT);
	LL_GPIO_SetPinMode(LD7_PORT, LD7, LL_GPIO_MODE_OUTPUT);

	LL_GPIO_SetPinMode(S1_PORT, S1, LL_GPIO_MODE_INPUT);
	LL_GPIO_SetPinMode(S2_PORT, S2, LL_GPIO_MODE_INPUT);
	LL_GPIO_SetPinMode(S3_PORT, S3, LL_GPIO_MODE_INPUT);

	LL_GPIO_SetOutputPin(LD0_PORT, LD0);
	LL_GPIO_SetOutputPin(LD1_PORT, LD1);
	LL_GPIO_SetOutputPin(LD2_PORT, LD2);
	LL_GPIO_SetOutputPin(LD3_PORT, LD3);
	LL_GPIO_SetOutputPin(LD4_PORT, LD4);
	LL_GPIO_SetOutputPin(LD5_PORT, LD5);
	LL_GPIO_SetOutputPin(LD6_PORT, LD6);
	LL_GPIO_SetOutputPin(LD7_PORT, LD7);

}


void LD0_Set(void){
	LL_GPIO_SetOutputPin(LD0_PORT, LD0);
}

void LD0_Reset(void){
	LL_GPIO_ResetOutputPin(LD0_PORT, LD0);
}

void LD1_Set(void){
	LL_GPIO_SetOutputPin(LD1_PORT, LD1);
}

void LD1_Reset(void){
	LL_GPIO_ResetOutputPin(LD1_PORT, LD1);
}

void LD2_Set(void){
	LL_GPIO_SetOutputPin(LD2_PORT, LD2);
}

void LD2_Reset(void){
	LL_GPIO_ResetOutputPin(LD2_PORT, LD2);
}

void LD3_Set(void){
	LL_GPIO_SetOutputPin(LD3_PORT, LD3);
}

void LD3_Reset(void){
	LL_GPIO_ResetOutputPin(LD3_PORT, LD3);
}

void LD4_Set(void){
	LL_GPIO_SetOutputPin(LD4_PORT, LD4);
}

void LD4_Reset(void){
	LL_GPIO_ResetOutputPin(LD4_PORT, LD4);
}

void LD5_Set(void){
	LL_GPIO_SetOutputPin(LD5_PORT, LD5);
}

void LD5_Reset(void){
	LL_GPIO_ResetOutputPin(LD5_PORT, LD5);
}

void LD6_Set(void){
	LL_GPIO_SetOutputPin(LD6_PORT, LD6);
}

void LD6_Reset(void){
	LL_GPIO_ResetOutputPin(LD6_PORT, LD6);
}

void LD7_Set(void){
	LL_GPIO_SetOutputPin(LD7_PORT, LD7);
}

void LD7_Reset(void){
	LL_GPIO_ResetOutputPin(LD7_PORT, LD7);
}
