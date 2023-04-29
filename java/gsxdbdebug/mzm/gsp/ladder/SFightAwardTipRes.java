/*    */ package mzm.gsp.ladder;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.award.AwardBean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SFightAwardTipRes
/*    */   extends __SFightAwardTipRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12607262;
/*    */   public AwardBean fightcountawardinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12607262;
/*    */   }
/*    */   
/*    */ 
/*    */   public SFightAwardTipRes()
/*    */   {
/* 33 */     this.fightcountawardinfo = new AwardBean();
/*    */   }
/*    */   
/*    */   public SFightAwardTipRes(AwardBean _fightcountawardinfo_) {
/* 37 */     this.fightcountawardinfo = _fightcountawardinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.fightcountawardinfo._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.fightcountawardinfo);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.fightcountawardinfo.unmarshal(_os_);
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SFightAwardTipRes)) {
/* 61 */       SFightAwardTipRes _o_ = (SFightAwardTipRes)_o1_;
/* 62 */       if (!this.fightcountawardinfo.equals(_o_.fightcountawardinfo)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.fightcountawardinfo.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.fightcountawardinfo).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\SFightAwardTipRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */