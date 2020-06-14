### Test_JavaSDKLib
------

###### 包结构
```
│  ReadMe.md
│
├─image
│  ├─algorithm
│  │      冒泡排序.gif
│  │      插入排序.gif
│  │      选择排序.gif
│  │
│  ├─data
│  │      deer.png
│  │
│  └─socket
│          HTTP 请求报文.jpg
│          HttpRequestMessage.jpg
│
└─src
    └─testlib
        │  Test_BigInteger1.java
        │  Test_BigInteger2.java
        │  Test_BigInteger3.java
        │  Test_ClassName.java
        │  Test_Desktop.java
        │  Test_JVMInfo.java
        │  Test_LoadPath1.java
        │  Test_LoadPath2.java
        │  Test_MultiSameTypeArgs.java
        │  Test_ParamReturnValue.java
        │  Test_Random.java
        │  Test_Random_3Way.java
        │  Test_Regex.java
        │  Test_RunCmd.java
        │  Test_RunEXE.java
        │  Test_Runtime.java
        │  Test_SystemProperty1.java
        │  Test_SystemProperty2.java
        │
        ├─algorithm
        │  │  DataProvider.java
        │  │
        │  └─soft
        │          Test_BubbleSort.java
        │          Test_BubbleSortPlus.java
        │          Test_InsertSort.java
        │          Test_SelectionSort.java
        │
        ├─anno
        │      A.java
        │      B.java
        │      C.java
        │      TestAnno.java
        │      UseAnno.java
        │
        ├─base
        │      Test_ByteRange.java
        │      Test_CharBytes.java
        │      Test_equals.java
        │      Test_Exception.java
        │      Test_Finally.java
        │      Test_For.java
        │      Test_HashCode.java
        │      Test_instanceof.java
        │      Test_Objects.java
        │      Test_OperatorPriority.java
        │      Test_Printf.java
        │      Test_SelfAddSub.java
        │      Test_UUID.java
        │
        ├─bean
        │      User.java
        │
        ├─clone
        │  │  C1.java
        │  │  C2.java
        │  │  Test_Clone.java
        │  │
        │  └─deepclone
        │          C1.java
        │          C2.java
        │          Test_DeepClone.java
        │
        ├─collection
        │      Test_ArrayAndList.java
        │      Test_CopyList.java
        │      Test_ListRemoveAll.java
        │      Test_ListSet.java
        │      Test_List_Remove.java
        │      Test_SetCollection.java
        │
        ├─enumclass
        │      EnumClass.java
        │      TestEnum.java
        │
        ├─file
        │      Test_CreateTempFile.java
        │      Test_DeleteDirPlus.java
        │      Test_File.java
        │
        ├─future
        │      CalledMethod.java
        │      MainMethod.java
        │
        ├─gui
        │  │  Test_CodeScanner.java
        │  │  Test_Event.java
        │  │  Test_JOptionPane.java
        │  │  Test_Toolkit.java
        │  │  Test_Toolkit2.java
        │  │
        │  ├─component
        │  │      Test_Component.java
        │  │      Test_JFileChooser.java
        │  │      Test_JTable1.java
        │  │      Test_JTable2.java
        │  │      Test_Menu.java
        │  │      Test_Menu.png
        │  │      Test_ProgressBar.java
        │  │
        │  ├─graphics
        │  │      Test_DynamicGraphics.java
        │  │      Test_Graphics.java
        │  │
        │  ├─JOptionPane
        │  │      Test_ConfirmDialog.java
        │  │      Test_InputDialog.java
        │  │      Test_InternalConfirmDialog.java
        │  │      Test_InternalMessageDialog.java
        │  │      Test_JOptionPane.java
        │  │      Test_JOptionPaneUI.java
        │  │      Test_JOptionPaneUI.png
        │  │      Test_MessageDialog.java
        │  │      Test_OptionDialog.java
        │  │      Test_OptionInputDialog.java
        │  │
        │  └─layout
        │          Test_BorderLayout.java
        │          Test_FlowLayout.java
        │          Test_GridLayout.java
        │
        ├─image
        │      Test_CircleCornerImage.java
        │      Test_CircleImage.java
        │      Test_RotateImage.java
        │
        ├─innerclass
        │      CustomAnnotation.java
        │      Outer.java
        │      Outer2.java
        │
        ├─io
        │      Test_ByteArrayStream.java
        │      Test_DataStream.java
        │      Test_ObjectStream.java
        │      Test_ReaderWriter.java
        │      Test_StringBufferInputStream.java
        │      Test_StringStream.java
        │
        ├─jaas
        │      CustomCallbackHander.java
        │      CustomLoginModule.java
        │      CustomPrincipal.java
        │      jaas.policy
        │      jaas2.config
        │      jaas2.policy
        │      Test_Jaas.java
        │      Test_Jaas2.java
        │
        ├─jdbc
        │      Test_JDBC.java
        │      Test_JDBC_SQLServer.java
        │
        ├─jdk8
        │      Test_CollectorstoMap.java
        │
        ├─jmx
        │  │  ConsoleClient.java
        │  │  HelloAgent.java
        │  │
        │  └─mbean
        │          Hello.java
        │          HelloMBean.java
        │
        ├─jvmerror
        │      Test_CreateThreadError.java
        │      Test_OutOfMemoryError.java
        │      Test_StackOverflowError.java
        │
        ├─map
        │      Test_MapKeyNull.java
        │      Test_Map_Entry.java
        │      Test_Map_Remove.java
        │      Test_TreeMap.java
        │
        ├─modifier
        │  │  Class_1.java
        │  │  Class_2.java
        │  │  Class_3.java
        │  │
        │  └─sub
        │          Class_2_1.java
        │          Class_3_1.java
        │
        ├─nio
        │  └─socketchannel
        │          AClient.java
        │          BClient.java
        │          CClient.java
        │          NioClient.java
        │          NioClientHandler.java
        │          NioServer.java
        │          ReadMe
        │
        ├─radix
        │      Test_BinOctHex.java
        │      Test_ByteArrayToHexString.java
        │      Test_HexStringToByteArray.java
        │      Test_IntegerSwitch.java
        │
        ├─security
        │      Test_JDK_MD5.java
        │
        ├─singleton
        │      Singleton1.java
        │      Singleton2.java
        │      Singleton3.java
        │      Singleton4.java
        │      UseSingleton.java
        │
        ├─socket
        │      Test_SocketClient.java
        │      Test_SocketRequest.java
        │      Test_SocketResponse.java
        │      Test_SocketServer.java
        │
        ├─string
        │      Test_StringBuilderClear.java
        │      Test_StringEquals.java
        │      Test_StringTokenizer.java
        │      Test_Unicode.java
        │
        ├─thread
        │      Test_Callable.java
        │      Test_Executors.java
        │
        ├─time
        │      Test_Calendar.java
        │      Test_CalendarWeekYear.java
        │      Test_LocalDateTime.java
        │      Test_LocalDateTime2.java
        │      Test_SimpleDateFormat.java
        │
        ├─timer
        │  │  Test_Timer.java
        │  │
        │  ├─example1
        │  │      Test_Timer.java
        │  │      TimerTask1.java
        │  │      TimerTask2.java
        │  │
        │  ├─example2
        │  │      Test_Example2.java
        │  │      TimerTask_Example2.java
        │  │
        │  └─exception
        │          CustomTimeTask1.java
        │          CustomTimeTask2.java
        │          CustomTimeTask3.java
        │          CustomTimeTask4.java
        │          Test_TimerException.java
        │
        ├─url
        │      Test_URLClassLoader.java
        │      Test_URLCodec.java
        │      Test_UrlGetHtml.java
        │      Test_URLRequest.java
        │
        ├─util
        │      IOUtils.java
        │
        └─xml
                Test_JavaXmlTransformer.java
                Test_XML_Map.java
```

