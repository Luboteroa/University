/*
 * app_nucleo_476.c
 *
 *  Created on: Oct 14, 2022
 *      Author: gosor
 */

#include "app_nucleo_l476.h"

typedef enum {UP,DOWN} push_button_t;
extern uint32_t Get_Tick(void);

void FSM_LD2_Blink(void){
	static uint32_t last_tick = 0;
	uint32_t current_tick;
	static uint8_t estado = 0;

	current_tick = Get_Tick();
	if (current_tick-last_tick >= 500){
		last_tick = current_tick;

		switch(estado){
		case 0:
			estado = 1;
			LD2_Set();
			break;
		case 1:
			estado = 0;
			LD2_Reset();
			break;
		}
	}
}

void FSM_Read_PushButton(uint8_t *flag2, uint8_t *flag, uint8_t *flag3){
	static uint32_t last_tick = 0;
	static push_button_t button_state  = UP;

	uint32_t current_tick;
	uint32_t idr;
	uint8_t B1;



	current_tick = Get_Tick();
	if (current_tick-last_tick >= 100){
		last_tick = current_tick;
		idr = LL_GPIO_ReadInputPort(S1_PORT);
		idr &= S1;
		(idr > 0) ?	(B1 = 1U) : (B1 = 0U);

		if (button_state == UP){
			if (B1 == 0)
				button_state = DOWN;
		}else{
			if (B1 == 1){
				button_state = UP;
				if (*flag==1)
				{
					*flag = 0;
					*flag2 = 0;
					*flag3 = 0;
				}
				else
				{
					*flag = 1;
					*flag2 = 0;
					*flag3 = 0;
				}
			}
		}
	}

}

void FSM_Read_PushButton2(uint8_t *flag2, uint8_t *flag, uint8_t *flag3){
	static uint32_t last_tick = 0;
	static push_button_t button_state  = UP;

	uint32_t current_tick;
	uint32_t idr;
	uint8_t B1;



	current_tick = Get_Tick();
	if (current_tick-last_tick >= 100){
		last_tick = current_tick;
		idr = LL_GPIO_ReadInputPort(S2_PORT);
		idr &= S2;
		(idr > 0) ?	(B1 = 1U) : (B1 = 0U);

		if (button_state == UP){
			if (B1 == 0)
				button_state = DOWN;
		}else{
			if (B1 == 1){
				button_state = UP;
				if (*flag2==1)
				{
					*flag = 0;
					*flag2 = 0;
					*flag3 = 0;
				}
				else
				{
					*flag = 0;
					*flag2 = 1;
					*flag3 = 0;
				}
			}
		}
	}

}

void FSM_Read_PushButton3(uint8_t *flag2, uint8_t *flag, uint8_t *flag3){
	static uint32_t last_tick = 0;
	static push_button_t button_state  = UP;

	uint32_t current_tick;
	uint32_t idr;
	uint8_t B1;



	current_tick = Get_Tick();
	if (current_tick-last_tick >= 100){
		last_tick = current_tick;
		idr = LL_GPIO_ReadInputPort(S3_PORT);
		idr &= S3;
		(idr > 0) ?	(B1 = 1U) : (B1 = 0U);

		if (button_state == UP){
			if (B1 == 0)
				button_state = DOWN;
		}else{
			if (B1 == 1){
				button_state = UP;
				if (*flag3==1)
				{
					*flag = 0;
					*flag2 = 0;
					*flag3 = 0;
				}
				else
				{
					*flag = 0;
					*flag2 = 0;
					*flag3 = 1;
				}
			}
		}
	}

}

void DireccionalDerecha(uint8_t *flag2, uint8_t *flag, uint8_t *flag3){

	static uint32_t last_tick = 0;
	static uint8_t secuencia_der = 0;
	uint32_t current_tick;

	current_tick = Get_Tick();

		if (*flag == 1)
		{
			if (current_tick-last_tick >= 1000)
			{
			last_tick = current_tick;
			switch(secuencia_der)
				{

			case 0:
				LD0_Set();
				LD1_Reset();
				LD2_Reset();
				LD3_Reset();
				LD4_Reset();
				LD5_Reset();
				LD6_Reset();
				LD7_Reset();
				secuencia_der =1;
				break;

			case 1:
				LD0_Set();
				LD1_Set();
				LD2_Reset();
				LD3_Reset();
				LD4_Reset();
				LD5_Reset();
				LD6_Reset();
				LD7_Reset();
				secuencia_der =2;
				break;

			case 2:
				LD0_Set();
				LD1_Set();
				LD2_Set();
				LD3_Reset();
				LD4_Reset();
				LD5_Reset();
				LD6_Reset();
				LD7_Reset();
				secuencia_der =3;
				break;

			case 3:
				LD0_Set();
				LD1_Set();
				LD2_Set();
				LD3_Set();
				LD4_Reset();
				LD5_Reset();
				LD6_Reset();
				LD7_Reset();
				secuencia_der =4;
				break;

			case 4:
				LD0_Set();
				LD1_Set();
				LD2_Set();
				LD3_Set();
				LD4_Set();
				LD5_Reset();
				LD6_Reset();
				LD7_Reset();
				secuencia_der =5;
				break;

			case 5:
				LD0_Set();
				LD1_Set();
				LD2_Set();
				LD3_Set();
				LD4_Set();
				LD5_Set();
				LD6_Reset();
				LD7_Reset();
				secuencia_der =6;
				break;

			case 6:
				LD0_Set();
				LD1_Set();
				LD2_Set();
				LD3_Set();
				LD4_Set();
				LD5_Set();
				LD6_Set();
				LD7_Reset();
				secuencia_der =7;
				break;

			case 7:
				LD0_Set();
				LD1_Set();
				LD2_Set();
				LD3_Set();
				LD4_Set();
				LD5_Set();
				LD6_Set();
				LD7_Set();
				secuencia_der =8;
				break;

			case 8:
				LD0_Reset();
				LD1_Reset();
				LD2_Reset();
				LD3_Reset();
				LD4_Reset();
				LD5_Reset();
				LD6_Reset();
				LD7_Reset();
				secuencia_der =0;
				break;
				}
			}
		}
}

void Stop(uint8_t *flag2, uint8_t *flag, uint8_t *flag3){
	static uint32_t last_tick = 0;
	static uint8_t stop = 0;
	uint32_t current_tick;

	current_tick = Get_Tick();

	if (*flag2 == 1)
	{
		if (current_tick-last_tick >= 500){
				last_tick = current_tick;

				switch(stop)
				{

				case 0:
					stop = 1;
					LD0_Set();
					LD1_Set();
					LD2_Set();
					LD3_Set();
					LD4_Set();
					LD5_Set();
					LD6_Set();
					LD7_Set();
					break;
				case 1:
					stop = 0;
					LD0_Reset();
					LD1_Reset();
					LD2_Reset();
					LD3_Reset();
					LD4_Reset();
					LD5_Reset();
					LD6_Reset();
					LD7_Reset();
					break;
				}
			}
	}
}

void DireccionalIzquierda(uint8_t *flag2, uint8_t *flag, uint8_t *flag3){

	static uint32_t last_tick = 0;
	static uint8_t secuencia_izq = 0;
	uint32_t current_tick;

	current_tick = Get_Tick();

		if (*flag3 == 1)
		{
			if (current_tick-last_tick >= 1000)
			{
			last_tick = current_tick;
			switch(secuencia_izq)
				{

			case 0:
				LD7_Set();
				LD6_Reset();
				LD5_Reset();
				LD4_Reset();
				LD3_Reset();
				LD2_Reset();
				LD1_Reset();
				LD0_Reset();
				secuencia_izq =1;
				break;

			case 1:
				LD7_Set();
				LD6_Set();
				LD5_Reset();
				LD4_Reset();
				LD3_Reset();
				LD2_Reset();
				LD1_Reset();
				LD0_Reset();
				secuencia_izq =2;
				break;

			case 2:
				LD7_Set();
				LD6_Set();
				LD5_Set();
				LD4_Reset();
				LD3_Reset();
				LD2_Reset();
				LD1_Reset();
				LD0_Reset();
				secuencia_izq =3;
				break;

			case 3:
				LD7_Set();
				LD6_Set();
				LD5_Set();
				LD4_Set();
				LD3_Reset();
				LD2_Reset();
				LD1_Reset();
				LD0_Reset();
				secuencia_izq =4;
				break;

			case 4:
				LD7_Set();
				LD6_Set();
				LD5_Set();
				LD4_Set();
				LD3_Set();
				LD2_Reset();
				LD1_Reset();
				LD0_Reset();
				secuencia_izq =5;
				break;

			case 5:
				LD7_Set();
				LD6_Set();
				LD5_Set();
				LD4_Set();
				LD3_Set();
				LD2_Set();
				LD1_Reset();
				LD0_Reset();
				secuencia_izq =6;
				break;

			case 6:
				LD7_Set();
				LD6_Set();
				LD5_Set();
				LD4_Set();
				LD3_Set();
				LD2_Set();
				LD1_Set();
				LD0_Reset();
				secuencia_izq =7;
				break;

			case 7:
				LD7_Set();
				LD6_Set();
				LD5_Set();
				LD4_Set();
				LD3_Set();
				LD2_Set();
				LD1_Set();
				LD7_Set();
				secuencia_izq =8;
				break;

			case 8:
				LD7_Reset();
				LD6_Reset();
				LD5_Reset();
				LD4_Reset();
				LD3_Reset();
				LD2_Reset();
				LD1_Reset();
				LD0_Reset();
				secuencia_izq =0;
				break;
				}
			}
		}
}
