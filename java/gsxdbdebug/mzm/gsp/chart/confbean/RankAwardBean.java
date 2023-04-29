/*    */ package mzm.gsp.chart.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class RankAwardBean implements Marshal
/*    */ {
/*    */   public int awardid;
/*    */   public int awardHonorid;
/*    */   public int rankMail;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.awardid = Integer.valueOf(rootElement.attributeValue("awardid")).intValue();
/* 16 */     this.awardHonorid = Integer.valueOf(rootElement.attributeValue("awardHonorid")).intValue();
/* 17 */     this.rankMail = Integer.valueOf(rootElement.attributeValue("rankMail")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.awardid);
/* 23 */     _os_.marshal(this.awardHonorid);
/* 24 */     _os_.marshal(this.rankMail);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.awardid = _os_.unmarshal_int();
/* 31 */     this.awardHonorid = _os_.unmarshal_int();
/* 32 */     this.rankMail = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\confbean\RankAwardBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */