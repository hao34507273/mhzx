/*    */ package mzm.gsp.menpaipvp;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class Score implements Marshal
/*    */ {
/*    */   public long roleid;
/*    */   public String name;
/*    */   public int score;
/*    */   public int win_times;
/*    */   
/*    */   public Score()
/*    */   {
/* 15 */     this.name = "";
/*    */   }
/*    */   
/*    */   public Score(long _roleid_, String _name_, int _score_, int _win_times_) {
/* 19 */     this.roleid = _roleid_;
/* 20 */     this.name = _name_;
/* 21 */     this.score = _score_;
/* 22 */     this.win_times = _win_times_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.roleid);
/* 31 */     _os_.marshal(this.name, "UTF-16LE");
/* 32 */     _os_.marshal(this.score);
/* 33 */     _os_.marshal(this.win_times);
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 38 */     this.roleid = _os_.unmarshal_long();
/* 39 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 40 */     this.score = _os_.unmarshal_int();
/* 41 */     this.win_times = _os_.unmarshal_int();
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 46 */     if (_o1_ == this) return true;
/* 47 */     if ((_o1_ instanceof Score)) {
/* 48 */       Score _o_ = (Score)_o1_;
/* 49 */       if (this.roleid != _o_.roleid) return false;
/* 50 */       if (!this.name.equals(_o_.name)) return false;
/* 51 */       if (this.score != _o_.score) return false;
/* 52 */       if (this.win_times != _o_.win_times) return false;
/* 53 */       return true;
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 59 */     int _h_ = 0;
/* 60 */     _h_ += (int)this.roleid;
/* 61 */     _h_ += this.name.hashCode();
/* 62 */     _h_ += this.score;
/* 63 */     _h_ += this.win_times;
/* 64 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 68 */     StringBuilder _sb_ = new StringBuilder();
/* 69 */     _sb_.append("(");
/* 70 */     _sb_.append(this.roleid).append(",");
/* 71 */     _sb_.append("T").append(this.name.length()).append(",");
/* 72 */     _sb_.append(this.score).append(",");
/* 73 */     _sb_.append(this.win_times).append(",");
/* 74 */     _sb_.append(")");
/* 75 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\Score.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */