/*    */ package mzm.gsp.superequipment.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SuperEquipmentPropertyImproveBean implements Marshal
/*    */ {
/*    */   public int type;
/*    */   public int value;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/* 15 */     this.value = Integer.valueOf(rootElement.attributeValue("value")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.type);
/* 21 */     _os_.marshal(this.value);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.type = _os_.unmarshal_int();
/* 28 */     this.value = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\confbean\SuperEquipmentPropertyImproveBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */