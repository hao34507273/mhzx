/*    */ package mzm.gsp.equipmentbless.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class EquipmentBlessExpBean implements Marshal
/*    */ {
/*    */   public int propertyBuff;
/*    */   public int requiredSuperEquipmentStage;
/*    */   public int requiredExp;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.propertyBuff = Integer.valueOf(rootElement.attributeValue("propertyBuff")).intValue();
/* 16 */     this.requiredSuperEquipmentStage = Integer.valueOf(rootElement.attributeValue("requiredSuperEquipmentStage")).intValue();
/* 17 */     this.requiredExp = Integer.valueOf(rootElement.attributeValue("requiredExp")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.propertyBuff);
/* 23 */     _os_.marshal(this.requiredSuperEquipmentStage);
/* 24 */     _os_.marshal(this.requiredExp);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.propertyBuff = _os_.unmarshal_int();
/* 31 */     this.requiredSuperEquipmentStage = _os_.unmarshal_int();
/* 32 */     this.requiredExp = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\equipmentbless\confbean\EquipmentBlessExpBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */