/*    */ package mzm.gsp.equipmentbless.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SEquipmentBlessExpRange implements Marshal
/*    */ {
/*    */   public int minExp;
/*    */   public int maxExp;
/*    */   public int weight;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.minExp = Integer.valueOf(rootElement.attributeValue("minExp")).intValue();
/* 16 */     this.maxExp = Integer.valueOf(rootElement.attributeValue("maxExp")).intValue();
/* 17 */     this.weight = Integer.valueOf(rootElement.attributeValue("weight")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.minExp);
/* 23 */     _os_.marshal(this.maxExp);
/* 24 */     _os_.marshal(this.weight);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.minExp = _os_.unmarshal_int();
/* 31 */     this.maxExp = _os_.unmarshal_int();
/* 32 */     this.weight = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\equipmentbless\confbean\SEquipmentBlessExpRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */