local OctetsStream = require("netio.OctetsStream")
local ItemXStoreType = class("ItemXStoreType")
ItemXStoreType.STRENGTH_LEVEL = 0
ItemXStoreType.ATTRI_A = 2
ItemXStoreType.ATTRI_B = 3
ItemXStoreType.STRENGTHEN_SCORE = 4
ItemXStoreType.USE_POINT_VALUE = 5
ItemXStoreType.EQUIP_SKILL = 6
ItemXStoreType.BAO_TU_X = 20
ItemXStoreType.BAO_TU_Y = 21
ItemXStoreType.BAO_TU_Z = 22
ItemXStoreType.BAO_TU_MAPID = 23
ItemXStoreType.PET_EQUIP_ATTRI_A = 40
ItemXStoreType.PET_EQUIP_ATTRI_B = 41
ItemXStoreType.PET_EQUIP_SKILL_ID_1 = 42
ItemXStoreType.PET_EQUIP_SKILL_ID_2 = 43
ItemXStoreType.PET_EQUIP_ATTRI_A_TYPE = 44
ItemXStoreType.PET_EQUIP_ATTRI_B_TYPE = 45
ItemXStoreType.ITEM_SOURCE = 46
ItemXStoreType.SHANGHUI_PRICE = 47
ItemXStoreType.EQUIP_FLAG = 53
ItemXStoreType.FABAO_OWN_SKILL_ID = 61
ItemXStoreType.FABAO_RANK_RANDOM_SKILL_ID = 66
ItemXStoreType.FABAO_NEXT_RANK_SKILL_ID = 67
ItemXStoreType.FABAO_AUTO_RANKUP_TO = 68
ItemXStoreType.FABAO_WASH_SKILL_ID = 71
ItemXStoreType.FABAO_CUR_RANK_EXP = 76
ItemXStoreType.FABAO_CUR_EXP = 77
ItemXStoreType.FABAO_CUR_LV = 78
ItemXStoreType.QILING_SCORE = 79
ItemXStoreType.MARKET_BUY_TIME = 100
ItemXStoreType.CAT_LEVEL = 120
ItemXStoreType.QILINZHU_USE_COUNT = 150
ItemXStoreType.ZHENGLINSHI_USE_COUNT = 151
ItemXStoreType.XINGYUNSHI_USE_COUNT = 152
ItemXStoreType.ACCUMULATION_QILIN_SCORE = 153
ItemXStoreType.CAN_ADD_INIT_QILIN_SCORE = 154
ItemXStoreType.CHILDREN_EQUIP_EXP = 170
ItemXStoreType.CHILDREN_EQUIP_LEVEL = 171
ItemXStoreType.CHILDREN_EQUIP_STAGE = 172
ItemXStoreType.CHILDREN_EQUIP_PROP_A = 173
ItemXStoreType.EQUIP_SKILL_TEMP = 190
ItemXStoreType.MAKER_ID_HIGH = 201
ItemXStoreType.MAKER_ID_LOW = 202
ItemXStoreType.BUFF_ID = 203
ItemXStoreType.ACTIVITY_CFG_ID = 204
ItemXStoreType.EXPERIENCE_VALUE = 205
ItemXStoreType.TOTAL_BOTTLE_EXP_VALUE = 211
ItemXStoreType.LEFT_BOTTLE_EXP_VALUE = 212
ItemXStoreType.LEFT_DOUBLE_ITEM_USE_TIMES = 221
ItemXStoreType.TIME_ITEM_END_TIME = 231
ItemXStoreType.SUPER_EQUIPMENT_STAGE = 241
ItemXStoreType.SUPER_EQUIPMENT_LEVEL = 242
ItemXStoreType.PK_REVENGE_ITEM_AVAILABLE_TIMES = 251
ItemXStoreType.PK_REVENGE_ITEM_BIND_HIGH = 252
ItemXStoreType.PK_REVENGE_ITEM_BIND_LOW = 253
ItemXStoreType.CHAINED_GIFT_BAG_USE_TIME = 261
ItemXStoreType.INDIANA_ACTIVITY_CFG_ID = 271
ItemXStoreType.INDIANA_ACTIVITY_TURN = 272
ItemXStoreType.INDIANA_SORT_ID = 273
ItemXStoreType.INDIANA_NUMBER = 274
ItemXStoreType.EQUIPMENT_BLESS_LEVEL = 281
ItemXStoreType.EQUIPMENT_BLESS_EXP = 282
ItemXStoreType.CAKE_MAKER_ID_HIGH = 291
ItemXStoreType.CAKE_MAKER_ID_LOW = 292
ItemXStoreType.CAKE_ACTIVITY_ID = 293
function ItemXStoreType:ctor()
end
function ItemXStoreType:marshal(os)
end
function ItemXStoreType:unmarshal(os)
end
return ItemXStoreType
