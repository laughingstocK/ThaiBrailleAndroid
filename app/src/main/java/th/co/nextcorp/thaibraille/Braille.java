package th.co.nextcorp.thaibraille;

import java.util.ArrayList;

public class Braille {
   public ArrayList<Byte> list = new ArrayList<Byte>() {{
      add((byte) 0);  // 0 ---
      add((byte) 0);  // 1 ---
      add((byte) 0);  // 2 ---
      add((byte) 0);  // 3 ---
      add((byte) 0);  // 4 ---
      add((byte) 0);  // 5 ---
      add((byte) 0);  // 6 ---
      add((byte) 0);  // 7 ---
      add((byte) 0);  // 8 ---
      add((byte) 0);  // 9 ---
      add((byte) 0);  // 10 ---
      add((byte) 0);  // 11 ---
      add((byte) 0);  // 12 ---
      add((byte) 0);  // 13 ---
      add((byte) 0);  // 14 ---
      add((byte) 0);  // 15 ---
      add((byte) 0);  // 16 ---
      add((byte) 0);  // 17 ---
      add((byte) 0);  // 18 ---
      add((byte) 0);  // 19 ---
      add((byte) 0);  // 20 ---
      add((byte) 0);  // 21 ---
      add((byte) 0);  // 22 ---
      add((byte) 0);  // 23 ---
      add((byte) 0);  // 24 ---
      add((byte) 0);  // 25 ---
      add((byte) 0);  // 26 ---
      add((byte) 0);  // 27 ---
      add((byte) 0);  // 28 ---
      add((byte) 0);  // 29 ---
      add((byte) 0);  // 30 ---
      add((byte) 0);  // 31 ---
      add((byte) 0);  // 32 ---
      add((byte) 0X2E);  // 33 --- !
      add((byte) 0X10);  // 34 --- "
      add((byte) 0X3C);  // 35 --- #
      add((byte) 0X2B);  // 36 --- $
      add((byte) 0X29);  // 37 --- %
      add((byte) 0X2F);  // 38 --- &
      add((byte) 0X04);  // 39 --- '
      add((byte) 0X37);  // 40 --- (
      add((byte) 0X3E);  // 41 --- )
      add((byte) 0X21);  // 42 --- *
      add((byte) 0X2C);  // 43 --- +
      add((byte) 0X20);  // 44 --- ,
      add((byte) 0X24);  // 45 --- -
      add((byte) 0X28);  // 46 --- .
      add((byte) 0X0C);  // 47 --- /
      add((byte) 0X34);  // 48 --- 0
      add((byte) 0X02);  // 49 --- 1
      add((byte) 0X06);  // 50 --- 2
      add((byte) 0X12);  // 51 --- 3
      add((byte) 0X32);  // 52 --- 4
      add((byte) 0X22);  // 53 --- 5
      add((byte) 0X16);  // 54 --- 6
      add((byte) 0X36);  // 55 --- 7
      add((byte) 0X26);  // 56 --- 8
      add((byte) 0X14);  // 57 --- 9
      add((byte) 0X31);  // 58 --- :
      add((byte) 0X30);  // 59 --- ;
      add((byte) 0X23);  // 60 --- <
      add((byte) 0X3F);  // 61 --- =
      add((byte) 0X1C);  // 62 --- >
      add((byte) 0X39);  // 63 --- ?
      add((byte) 0X48);  // 64 --- @
      add((byte) 0X41);  // 65 --- A
      add((byte) 0X43);  // 66 --- B
      add((byte) 0X49);  // 67 --- C
      add((byte) 0X59);  // 68 --- D
      add((byte) 0X51);  // 69 --- E
      add((byte) 0X4B);  // 70 --- F
      add((byte) 0X5B);  // 71 --- G
      add((byte) 0X53);  // 72 --- H
      add((byte) 0X4A);  // 73 --- I
      add((byte) 0X5A);  // 74 --- J
      add((byte) 0X45);  // 75 --- K
      add((byte) 0X47);  // 76 --- L
      add((byte) 0X4D);  // 77 --- M
      add((byte) 0X5D);  // 78 --- N
      add((byte) 0X55);  // 79 --- O
      add((byte) 0X4F);  // 80 --- P
      add((byte) 0X5F);  // 81 --- Q
      add((byte) 0X57);  // 82 --- R
      add((byte) 0X4E);  // 83 --- S
      add((byte) 0X5E);  // 84 --- T
      add((byte) 0X65);  // 85 --- U
      add((byte) 0X67);  // 86 --- V
      add((byte) 0X7A);  // 87 --- W
      add((byte) 0X6D);  // 88 --- X
      add((byte) 0X7D);  // 89 --- Y
      add((byte) 0X75);  // 90 --- Z
      add((byte) 0X6A);  // 91 --- [
      add((byte) 0X73);  // 92 --- \
      add((byte) 0X7B);  // 93 --- ]
      add((byte) 0X58);  // 94 --- ^
      add((byte) 0X78);  // 95 --- _
      add((byte) 0X08);  // 96 --- `
      add((byte) 0X01);  // 97 --- a
      add((byte) 0X03);  // 98 --- b
      add((byte) 0X09);  // 99 --- c
      add((byte) 0X19);  // 100 --- d
      add((byte) 0X11);  // 101 --- e
      add((byte) 0X0B);  // 102 --- f
      add((byte) 0X1B);  // 103 --- g
      add((byte) 0X13);  // 104 --- h
      add((byte) 0X0A);  // 105 --- i
      add((byte) 0X1A);  // 106 --- j
      add((byte) 0X05);  // 107 --- k
      add((byte) 0X07);  // 108 --- l
      add((byte) 0X0D);  // 109 --- m
      add((byte) 0X1D);  // 110 --- n
      add((byte) 0X15);  // 111 --- o
      add((byte) 0X0F);  // 112 --- p
      add((byte) 0X1F);  // 113 --- q
      add((byte) 0X17);  // 114 --- r
      add((byte) 0X0E);  // 115 --- s
      add((byte) 0X1E);  // 116 --- t
      add((byte) 0X25);  // 117 --- u
      add((byte) 0X27);  // 118 --- v
      add((byte) 0X3A);  // 119 --- w
      add((byte) 0X2D);  // 120 --- x
      add((byte) 0X3D);  // 121 --- y
      add((byte) 0X35);  // 122 --- z
      add((byte) 0X2A);  // 123 --- {
      add((byte) 0X33);  // 124 --- |
      add((byte) 0X3B);  // 125 --- }
      add((byte) 0X18);  // 126 --- ~
      add((byte) 0);  // 127 ---
      add((byte) 0);  // 128 ---
      add((byte) 0);  // 129 ---
      add((byte) 0);  // 130 ---
      add((byte) 0);  // 131 ---
      add((byte) 0);  // 132 ---
      add((byte) 0);  // 133 ---
      add((byte) 0);  // 134 ---
      add((byte) 0);  // 135 ---
      add((byte) 0);  // 136 ---
      add((byte) 0);  // 137 ---
      add((byte) 0);  // 138 ---
      add((byte) 0);  // 139 ---
      add((byte) 0);  // 140 ---
      add((byte) 0);  // 141 ---
      add((byte) 0);  // 142 ---
      add((byte) 0);  // 143 ---
      add((byte) 0);  // 144 ---
      add((byte) 0);  // 145 --- ‘
      add((byte) 0);  // 146 --- ’
      add((byte) 0X10);  // 147 --- “
      add((byte) 0X10);  // 148 ---
      add((byte) 0);  // 149 ---
      add((byte) 0);  // 150 --- –
      add((byte) 0);  // 151 ---
      add((byte) 0);  // 152 ---
      add((byte) 0);  // 153 ---
      add((byte) 0);  // 154 ---
      add((byte) 0);  // 155 ---
      add((byte) 0);  // 156 ---
      add((byte) 0);  // 157 ---
      add((byte) 0);  // 158 ---
      add((byte) 0);  // 159 ---
      add((byte) 0);  // 160 ---
      add((byte) 0X1B);  // 161 --- ก
      add((byte) 0X05);  // 162 --- ข
      add((byte) 0XC5);  // 163 --- ฃ
      add((byte) 0X25);  // 164 --- ค
      add((byte) 0XA5);  // 165 --- ฅ
      add((byte) 0X65);  // 166 --- ฆ
      add((byte) 0X3B);  // 167 --- ง
      add((byte) 0X1A);  // 168 --- จ
      add((byte) 0X0C);  // 169 --- ฉ
      add((byte) 0X2C);  // 170 --- ช
      add((byte) 0X2E);  // 171 --- ซ
      add((byte) 0X6C);  // 172 --- ฌ
      add((byte) 0X7D);  // 173 ---
      add((byte) 0X59);  // 174 --- ฎ
      add((byte) 0X73);  // 175 ---
      add((byte) 0X5E);  // 176 ---
      add((byte) 0X7E);  // 177 --- ฑ
      add((byte) 0XBE);  // 178 --- ฒ
      add((byte) 0X5D);  // 179 --- ณ
      add((byte) 0X19);  // 180 --- ด
      add((byte) 0X33);  // 181 --- ต
      add((byte) 0X1E);  // 182 --- ถ
      add((byte) 0X3E);  // 183 --- ท
      add((byte) 0XFE);  // 184 --- ธ
      add((byte) 0X1D);  // 185 --- น
      add((byte) 0X27);  // 186 --- บ
      add((byte) 0X2F);  // 187 --- ป
      add((byte) 0X0F);  // 188 --- ผ
      add((byte) 0X2D);  // 189 ---
      add((byte) 0X39);  // 190 --- พ
      add((byte) 0X2B);  // 191 --- ฟ
      add((byte) 0X79);  // 192 --- ภ
      add((byte) 0X0D);  // 193 --- ม
      add((byte) 0X3D);  // 194 --- ย
      add((byte) 0X17);  // 195 --- ร
      add((byte) 0X97);  // 196 --- ฤ
      add((byte) 0X07);  // 197 --- ล
      add((byte) 0X87);  // 198 --- ฦ
      add((byte) 0X3A);  // 199 --- ว
      add((byte) 0X4E);  // 200 --- ศ
      add((byte) 0X8E);  // 201 --- ษ
      add((byte) 0X0E);  // 202 --- ส
      add((byte) 0X13);  // 203 --- ห
      add((byte) 0X47);  // 204 --- ฬ
      add((byte) 0X15);  // 205 --- อ
      add((byte) 0X3F);  // 206 --- ฮ
      add((byte) 0XB0);  // 207 --- ฯ
      add((byte) 0X01);  // 208 --- ะ
      add((byte) 0X1C);  // 209 --- อั
      add((byte) 0X21);  // 210 --- อา
      add((byte) 0X35);  // 211 --- อำ
      add((byte) 0X03);  // 212 --- อิ
      add((byte) 0X06);  // 213 --- อี
      add((byte) 0X2A);  // 214 --- อึ
      add((byte) 0X22);  // 215 --- อื
      add((byte) 0X09);  // 216 --- อุ
      add((byte) 0X12);  // 217 --- อู
      add((byte) 0X84);  // 218 --- อฺ
      add((byte) 0X83);  // 219 --- ฻
      add((byte) 0X0B);  // 220 --- เ
      add((byte) 0X23);  // 221 ---
      add((byte) 0X0A);  // 222 --- โ
      add((byte) 0XB1);  // 223 --- ใ
      add((byte) 0X31);  // 224 --- ไ
      add((byte) 0XA1);  // 225 --- ๅ
      add((byte) 0X02);  // 226 --- ๆ
      add((byte) 0X04);  // 227 --- อ็
      add((byte) 0X14);  // 228 --- อ่
      add((byte) 0X32);  // 229 --- อ้
      add((byte) 0X36);  // 230 --- อ๊
      add((byte) 0X26);  // 231 --- อ๋
      add((byte) 0X34);  // 232 --- อ์
      add((byte) 0X90);  // 233 --- ◌
      add((byte) 0X91);  // 234 --- ◌
      add((byte) 0X89);  // 235 ---
      add((byte) 0X74);  // 236 --- 0
      add((byte) 0X42);  // 237 --- 1
      add((byte) 0X46);  // 238 --- 2
      add((byte) 0X52);  // 239 --- 3
      add((byte) 0X72);  // 240 --- 4
      add((byte) 0X62);  // 241 --- 5
      add((byte) 0X56);  // 242 --- 6
      add((byte) 0X76);  // 243 --- 7
      add((byte) 0X66);  // 244 --- 8
      add((byte) 0X54);  // 245 --- 9
      add((byte) 0XB2);  // 246 --- ๚
      add((byte) 0X86);  // 247 --- ๛
      add((byte) 0XA0);  // 248 ---
   }};

   public static void main(String[] args) {
      // create an empty array list with an initial capacity

   }
}