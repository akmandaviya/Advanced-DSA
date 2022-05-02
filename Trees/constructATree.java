����   = ]  Trees/constructATree  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this LTrees/constructATree; 	buildTree ([I[I)LTrees/Node;  java/util/HashMap
  	
    java/lang/Integer   valueOf (I)Ljava/lang/Integer;
     put 8(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
     )([III[IIILjava/util/HashMap;)LTrees/Node; preOrder [I inOrder map Ljava/util/HashMap; i I root LTrees/Node; LocalVariableTypeTable ;Ljava/util/HashMap<Ljava/lang/Integer;Ljava/lang/Integer;>; StackMapTable 	Signature Q([III[IIILjava/util/HashMap<Ljava/lang/Integer;Ljava/lang/Integer;>;)LTrees/Node; / 
Trees/Node
 . 1  2 (I)V	 . 4 5 & data
  7 8 9 get &(Ljava/lang/Object;)Ljava/lang/Object;
  ; < = intValue ()I	 . ? @ ( left	 . B C ( right preStart preEnd inStart inEnd inRoot numLeft main ([Ljava/lang/String;)V
  M  	 O Q P java/lang/System R S out Ljava/io/PrintStream;
 U W V java/io/PrintStream X 2 println args [Ljava/lang/String; 
SourceFile constructATree.java !               /     *� �    
                    	       �     8� Y� M>� ,+.� � � W�+����**�d++�d,� N-�    
   "           %  +  2  6     4    8   !     8 " !   0 # $  
  % &  6  ' (  )      0 # *  +   
 �   	    ,    -   '  
   k� 
� �� .Y*.� 0:� 3� � 6� � :6d6	*`	`-d� � >*	``-`� � A�    
   "    #  $  '  ) / * 6 , O . h 0    f 
   k   !     k D &    k E &    k " !    k F &    k G &    k # $   Q ' (  / < H &  6 5 I & 	 )       k # *  +     	 J K     �     W�
Y
OYOY(OY2OYOY<OL�
Y(OYOY2OY
OY<OYOM+,� LN� N-� 3� T�    
       4 # 5 F 6 L 8 V 9    *    W Y Z   # 4   !  F  " !  L  ' (   [    \