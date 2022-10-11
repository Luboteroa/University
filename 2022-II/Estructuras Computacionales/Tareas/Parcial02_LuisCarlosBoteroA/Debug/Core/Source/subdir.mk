################################################################################
# Automatically-generated file. Do not edit!
# Toolchain: GNU Tools for STM32 (10.3-2021.10)
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
S_SRCS += \
../Core/Source/main.s 

OBJS += \
./Core/Source/main.o 

S_DEPS += \
./Core/Source/main.d 


# Each subdirectory must supply rules for building sources it contributes
Core/Source/%.o: ../Core/Source/%.s Core/Source/subdir.mk
	arm-none-eabi-gcc -mcpu=cortex-m4 -g3 -DDEBUG -c -I"C:/Users/nomei/OneDrive/Escritorio/Estructuras Comp/Led_Sequence_Control_s/Drivers/STM32L476_MSP_ASM/Include" -I"C:/Users/nomei/OneDrive/Escritorio/Estructuras Comp/Led_Sequence_Control_s/Drivers/STM32L476_BSP_N64_ASM/Include" -I"C:/Users/nomei/OneDrive/Escritorio/Estructuras Comp/Led_Sequence_Control_s/Core/Include" -x assembler-with-cpp -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" --specs=nano.specs -mfpu=fpv4-sp-d16 -mfloat-abi=hard -mthumb -o "$@" "$<"

clean: clean-Core-2f-Source

clean-Core-2f-Source:
	-$(RM) ./Core/Source/main.d ./Core/Source/main.o

.PHONY: clean-Core-2f-Source

