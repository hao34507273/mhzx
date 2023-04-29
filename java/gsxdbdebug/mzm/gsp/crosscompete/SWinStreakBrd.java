/*    */ package mzm.gsp.crosscompete;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
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
/*    */ public class SWinStreakBrd
/*    */   extends __SWinStreakBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12616723;
/*    */   public long roleid;
/*    */   public String name;
/*    */   public int win_streak;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12616723;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SWinStreakBrd()
/*    */   {
/* 35 */     this.name = "";
/*    */   }
/*    */   
/*    */   public SWinStreakBrd(long _roleid_, String _name_, int _win_streak_) {
/* 39 */     this.roleid = _roleid_;
/* 40 */     this.name = _name_;
/* 41 */     this.win_streak = _win_streak_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.roleid);
/* 50 */     _os_.marshal(this.name, "UTF-16LE");
/* 51 */     _os_.marshal(this.win_streak);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.roleid = _os_.unmarshal_long();
/* 57 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 58 */     this.win_streak = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SWinStreakBrd)) {
/* 68 */       SWinStreakBrd _o_ = (SWinStreakBrd)_o1_;
/* 69 */       if (this.roleid != _o_.roleid) return false;
/* 70 */       if (!this.name.equals(_o_.name)) return false;
/* 71 */       if (this.win_streak != _o_.win_streak) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += (int)this.roleid;
/* 80 */     _h_ += this.name.hashCode();
/* 81 */     _h_ += this.win_streak;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.roleid).append(",");
/* 89 */     _sb_.append("T").append(this.name.length()).append(",");
/* 90 */     _sb_.append(this.win_streak).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\SWinStreakBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */