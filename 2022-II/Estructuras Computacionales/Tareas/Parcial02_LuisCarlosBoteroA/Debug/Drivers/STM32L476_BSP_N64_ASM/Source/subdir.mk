################################################################################
# Automatically-generated file. Do not edit!
# Toolchain: GNU Tools for STM32 (10.3-2021.10)
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
S_SRCS += \
../Drivers/STM32L476_BSP_N64_ASM/Source/stm32l476_bsp_ng4.s 

OBJS += \
./Drivers/STM32L476_BSP_N64_ASM/Source/stm32l476_bsp_ng4.o 

S_DEPS += \
./Drivers/STM32L476_BSP_N64_ASM/Source/stm32l476_bsp_ng4.d 


# Each subdirectory must supply rules for building sources it contributes
Drivers/STM32L476_BSP_N64_ASM/Source/%.o: ../Drivers/STM32L476_BSP_N64_ASM/Source/%.s Drivers/STM32L476_BSP_N64_ASM/Source/subdir.mk
	arm-none-eabi-gcc -mcpu=cortex-m4 -g3 -DDEBUG -c -I"C:/Users/nomei/OneDrive/Escritorio/Estructuras Comp/Led_Sequence_Control_s/Drivers/STM32L476_MSP_ASM/Include" -I"C:/Users/nomei/OneDrive/Escritorio/Estructuras Comp/Led_Sequence_Control_s/Drivers/STM32L476_BSP_N64_ASM/Include" -I"C:/Users/nomei/OneDrive/Escritorio/Estructuras Comp/Led_Sequence_Control_s/Core/Include" -x assembler-with-cpp -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" --specs=nano.specs -mfpu=fpv4-sp-d16 -mfloat-abi=hard -mthumb -o "$@" "$<"

clean: clean-Drivers-2f-STM32L476_BSP_N64_ASM-2f-Source

clean-Drivers-2f-STM32L476_BSP_N64_ASM-2f-Source:
	-$(RM) ./Drivers/STM32L476_BSP_N64_ASM/Source/stm32l476_bsp_ng4.d ./Drivers/STM32L476_BSP_N64_ASM/Source/stm32l476_bsp_ng4.o

.PHONY: clean-Drivers-2f-STM32L476_BSP_N64_ASM-2f-Source

