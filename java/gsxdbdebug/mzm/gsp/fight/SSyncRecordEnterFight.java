/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
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
/*    */ public class SSyncRecordEnterFight
/*    */   extends __SSyncRecordEnterFight__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594216;
/*    */   public long recordid;
/*    */   public Octets enter_fight_content;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12594216;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncRecordEnterFight()
/*    */   {
/* 34 */     this.enter_fight_content = new Octets();
/*    */   }
/*    */   
/*    */   public SSyncRecordEnterFight(long _recordid_, Octets _enter_fight_content_) {
/* 38 */     this.recordid = _recordid_;
/* 39 */     this.enter_fight_content = _enter_fight_content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.recordid);
/* 48 */     _os_.marshal(this.enter_fight_content);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.recordid = _os_.unmarshal_long();
/* 54 */     this.enter_fight_content = _os_.unmarshal_Octets();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SSyncRecordEnterFight)) {
/* 64 */       SSyncRecordEnterFight _o_ = (SSyncRecordEnterFight)_o1_;
/* 65 */       if (this.recordid != _o_.recordid) return false;
/* 66 */       if (!this.enter_fight_content.equals(_o_.enter_fight_content)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.recordid;
/* 75 */     _h_ += this.enter_fight_content.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.recordid).append(",");
/* 83 */     _sb_.append("B").append(this.enter_fight_content.size()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\SSyncRecordEnterFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */