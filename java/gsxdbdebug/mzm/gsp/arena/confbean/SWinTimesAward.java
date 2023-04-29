/*    */ package mzm.gsp.arena.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SWinTimesAward implements Marshal
/*    */ {
/*    */   public int winTimes;
/*    */   public int award;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.winTimes = Integer.valueOf(rootElement.attributeValue("winTimes")).intValue();
/* 15 */     this.award = Integer.valueOf(rootElement.attributeValue("award")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.winTimes);
/* 21 */     _os_.marshal(this.award);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.winTimes = _os_.unmarshal_int();
/* 28 */     this.award = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\confbean\SWinTimesAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */