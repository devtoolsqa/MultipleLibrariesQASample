package com.example.kotlinpracticeudemy

class EnumClass {

          enum class EmployeeTypes{
                    FullTime,
                    Vendor,
                    Contractor,
                    Intern,
                    Other
          }

          enum class EmployeeCount(val count:Int){
                    FullTime(10),
                    Vendor(20),
                    Contractor(30),
                    Intern (40)
          }

          fun main()
          {
                    val employeeType=getEmployeeType("full")
                   val employeeCount=EmployeeCount.FullTime.count

                    when(employeeType)
                    {
                              EmployeeTypes.Vendor -> println("Vendor")
                              EmployeeTypes.Contractor -> println("Contractor")
                              EmployeeTypes.Intern -> println("Intern")
                              EmployeeTypes.FullTime -> println("Full Time")
                              EmployeeTypes.Other -> println("Other")
                    }
          }

          private fun getEmployeeType(type: String): EmployeeTypes {
                    return if(type=="full") {
                              EmployeeTypes.FullTime
                    } else {
                              EmployeeTypes.Other
                    }

          }

}