/*    */ package mzm.gsp.zhenfa.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class RestrictZhenfaBean implements Marshal
/*    */ {
/*    */   public int zhenfaId;
/*    */   public int effectId;
/*    */   public int restValue;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.zhenfaId = Integer.valueOf(rootElement.attributeValue("zhenfaId")).intValue();
/* 16 */     this.effectId = Integer.valueOf(rootElement.attributeValue("effectId")).intValue();
/* 17 */     this.restValue = Integer.valueOf(rootElement.attributeValue("restValue")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.zhenfaId);
/* 23 */     _os_.marshal(this.effectId);
/* 24 */     _os_.marshal(this.restValue);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.zhenfaId = _os_.unmarshal_int();
/* 31 */     this.effectId = _os_.unmarshal_int();
/* 32 */     this.restValue = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenfa\confbean\RestrictZhenfaBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */