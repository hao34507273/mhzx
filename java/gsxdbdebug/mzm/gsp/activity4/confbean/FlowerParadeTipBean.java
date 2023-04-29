/*    */ package mzm.gsp.activity4.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class FlowerParadeTipBean implements Marshal
/*    */ {
/*    */   public String tipId;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 13 */     this.tipId = rootElement.attributeValue("tipId");
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 18 */     _os_.marshal(this.tipId, "UTF-8");
/* 19 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 24 */     this.tipId = _os_.unmarshal_String("UTF-8");
/* 25 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity4\confbean\FlowerParadeTipBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */