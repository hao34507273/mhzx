/*    */ package mzm.gsp.alllotto.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SAllLottoConditionInfo implements Marshal
/*    */ {
/*    */   public int condition_type;
/*    */   public int condition_value;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.condition_type = Integer.valueOf(rootElement.attributeValue("condition_type")).intValue();
/* 15 */     this.condition_value = Integer.valueOf(rootElement.attributeValue("condition_value")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.condition_type);
/* 21 */     _os_.marshal(this.condition_value);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.condition_type = _os_.unmarshal_int();
/* 28 */     this.condition_value = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\confbean\SAllLottoConditionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */