################################################################################
# Automatically-generated file. Do not edit!
# Toolchain: GNU Tools for STM32 (10.3-2021.10)
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
S_SRCS += \
../Core/Include/main_h.s 

OBJS += \
./Core/Include/main_h.o 

S_DEPS += \
./Core/Include/main_h.d 


# Each subdirectory must supply rules for building sources it contributes
Core/Include/%.o: ../Core/Include/%.s Core/Include/subdir.mk
	arm-none-eabi-gcc -mcpu=cortex-m4 -g3 -DDEBUG -c -I"C:/Users/nomei/OneDrive/Escritorio/Estructuras Comp/Led_Sequence_Control_s/Drivers/STM32L476_MSP_ASM/Include" -I"C:/Users/nomei/OneDrive/Escritorio/Estructuras Comp/Led_Sequence_Control_s/Drivers/STM32L476_BSP_N64_ASM/Include" -I"C:/Users/nomei/OneDrive/Escritorio/Estructuras Comp/Led_Sequence_Control_s/Core/Include" -x assembler-with-cpp -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" --specs=nano.specs -mfpu=fpv4-sp-d16 -mfloat-abi=hard -mthumb -o "$@" "$<"

clean: clean-Core-2f-Include

clean-Core-2f-Include:
	-$(RM) ./Core/Include/main_h.d ./Core/Include/main_h.o

.PHONY: clean-Core-2f-Include

