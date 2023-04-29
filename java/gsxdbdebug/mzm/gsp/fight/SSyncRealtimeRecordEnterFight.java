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
/*    */ public class SSyncRealtimeRecordEnterFight
/*    */   extends __SSyncRealtimeRecordEnterFight__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594219;
/*    */   public long recordid;
/*    */   public int rounds;
/*    */   public Octets enter_fight_content;
/*    */   public byte is_realtime;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12594219;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSyncRealtimeRecordEnterFight()
/*    */   {
/* 36 */     this.enter_fight_content = new Octets();
/*    */   }
/*    */   
/*    */   public SSyncRealtimeRecordEnterFight(long _recordid_, int _rounds_, Octets _enter_fight_content_, byte _is_realtime_) {
/* 40 */     this.recordid = _recordid_;
/* 41 */     this.rounds = _rounds_;
/* 42 */     this.enter_fight_content = _enter_fight_content_;
/* 43 */     this.is_realtime = _is_realtime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.recordid);
/* 52 */     _os_.marshal(this.rounds);
/* 53 */     _os_.marshal(this.enter_fight_content);
/* 54 */     _os_.marshal(this.is_realtime);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.recordid = _os_.unmarshal_long();
/* 60 */     this.rounds = _os_.unmarshal_int();
/* 61 */     this.enter_fight_content = _os_.unmarshal_Octets();
/* 62 */     this.is_realtime = _os_.unmarshal_byte();
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof SSyncRealtimeRecordEnterFight)) {
/* 72 */       SSyncRealtimeRecordEnterFight _o_ = (SSyncRealtimeRecordEnterFight)_o1_;
/* 73 */       if (this.recordid != _o_.recordid) return false;
/* 74 */       if (this.rounds != _o_.rounds) return false;
/* 75 */       if (!this.enter_fight_content.equals(_o_.enter_fight_content)) return false;
/* 76 */       if (this.is_realtime != _o_.is_realtime) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += (int)this.recordid;
/* 85 */     _h_ += this.rounds;
/* 86 */     _h_ += this.enter_fight_content.hashCode();
/* 87 */     _h_ += this.is_realtime;
/* 88 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 92 */     StringBuilder _sb_ = new StringBuilder();
/* 93 */     _sb_.append("(");
/* 94 */     _sb_.append(this.recordid).append(",");
/* 95 */     _sb_.append(this.rounds).append(",");
/* 96 */     _sb_.append("B").append(this.enter_fight_content.size()).append(",");
/* 97 */     _sb_.append(this.is_realtime).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\SSyncRealtimeRecordEnterFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */