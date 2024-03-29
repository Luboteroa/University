/*
 * app_nucleo_l476.h
 *
 *  Created on: Oct 14, 2022
 *      Author: gosor
 */

#ifndef INCLUDE_APP_NUCLEO_L476_H_
#define INCLUDE_APP_NUCLEO_L476_H_

#include "hal_nucleo_l476.h"
// Finite State Machines
void FSM_LD2_Blink(void);
void FSM_Read_PushButton(uint8_t *flag2, uint8_t *flag, uint8_t *flag3);
void FSM_Read_PushButton2(uint8_t *flag2, uint8_t *flag, uint8_t *flag3);
void FSM_Read_PushButton3(uint8_t *flag2, uint8_t *flag, uint8_t *flag3);
void DireccionalDerecha(uint8_t *flag2, uint8_t *flag, uint8_t *flag3);
void DireccionalIzquierda(uint8_t *flag2, uint8_t *flag, uint8_t *flag3);
void Stop(uint8_t *flag2, uint8_t *flag, uint8_t *flag3);

#endif /* INCLUDE_APP_NUCLEO_L476_H_ */
