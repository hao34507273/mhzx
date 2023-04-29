/*    */ package mzm.gsp.treasurehunt.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class ChapterEffect implements Marshal
/*    */ {
/*    */   public int map_item_id_effect_type;
/*    */   public int map_item_id_effect_parameter_1;
/*    */   public int map_item_id_effect_parameter_2;
/*    */   public int item_num;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.map_item_id_effect_type = Integer.valueOf(rootElement.attributeValue("map_item_id_effect_type")).intValue();
/* 17 */     this.map_item_id_effect_parameter_1 = Integer.valueOf(rootElement.attributeValue("map_item_id_effect_parameter_1")).intValue();
/* 18 */     this.map_item_id_effect_parameter_2 = Integer.valueOf(rootElement.attributeValue("map_item_id_effect_parameter_2")).intValue();
/* 19 */     this.item_num = Integer.valueOf(rootElement.attributeValue("item_num")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 24 */     _os_.marshal(this.map_item_id_effect_type);
/* 25 */     _os_.marshal(this.map_item_id_effect_parameter_1);
/* 26 */     _os_.marshal(this.map_item_id_effect_parameter_2);
/* 27 */     _os_.marshal(this.item_num);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 33 */     this.map_item_id_effect_type = _os_.unmarshal_int();
/* 34 */     this.map_item_id_effect_parameter_1 = _os_.unmarshal_int();
/* 35 */     this.map_item_id_effect_parameter_2 = _os_.unmarshal_int();
/* 36 */     this.item_num = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\treasurehunt\confbean\ChapterEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */