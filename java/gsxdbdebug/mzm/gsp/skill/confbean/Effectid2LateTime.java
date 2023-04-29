/*    */ package mzm.gsp.skill.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class Effectid2LateTime implements Marshal
/*    */ {
/*    */   public int effectid;
/*    */   public int lateTime;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.effectid = Integer.valueOf(rootElement.attributeValue("effectid")).intValue();
/* 15 */     this.lateTime = Integer.valueOf(rootElement.attributeValue("lateTime")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.effectid);
/* 21 */     _os_.marshal(this.lateTime);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.effectid = _os_.unmarshal_int();
/* 28 */     this.lateTime = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\confbean\Effectid2LateTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */