/*    */ package mzm.gsp.buff.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class BuffEffect implements Marshal
/*    */ {
/*    */   public int effectId;
/*    */   public int effectValue;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.effectId = Integer.valueOf(rootElement.attributeValue("effectId")).intValue();
/* 15 */     this.effectValue = Integer.valueOf(rootElement.attributeValue("effectValue")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.effectId);
/* 21 */     _os_.marshal(this.effectValue);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.effectId = _os_.unmarshal_int();
/* 28 */     this.effectValue = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\confbean\BuffEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */