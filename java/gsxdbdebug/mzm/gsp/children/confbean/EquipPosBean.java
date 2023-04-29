/*    */ package mzm.gsp.children.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class EquipPosBean implements Marshal
/*    */ {
/*    */   public int equip_pos_level;
/*    */   public int equip_pos_stage;
/*    */   public int equip_pos_exp;
/*    */   public int equip_pos_pro;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.equip_pos_level = Integer.valueOf(rootElement.attributeValue("equip_pos_level")).intValue();
/* 17 */     this.equip_pos_stage = Integer.valueOf(rootElement.attributeValue("equip_pos_stage")).intValue();
/* 18 */     this.equip_pos_exp = Integer.valueOf(rootElement.attributeValue("equip_pos_exp")).intValue();
/* 19 */     this.equip_pos_pro = Integer.valueOf(rootElement.attributeValue("equip_pos_pro")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 24 */     _os_.marshal(this.equip_pos_level);
/* 25 */     _os_.marshal(this.equip_pos_stage);
/* 26 */     _os_.marshal(this.equip_pos_exp);
/* 27 */     _os_.marshal(this.equip_pos_pro);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 33 */     this.equip_pos_level = _os_.unmarshal_int();
/* 34 */     this.equip_pos_stage = _os_.unmarshal_int();
/* 35 */     this.equip_pos_exp = _os_.unmarshal_int();
/* 36 */     this.equip_pos_pro = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\confbean\EquipPosBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */