/*    */ package mzm.gsp.singlebattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class FightRecord implements Marshal, Comparable<FightRecord>
/*    */ {
/*    */   public int diecount;
/*    */   public int killcount;
/*    */   public int revivetime;
/*    */   
/*    */   public FightRecord() {}
/*    */   
/*    */   public FightRecord(int _diecount_, int _killcount_, int _revivetime_)
/*    */   {
/* 17 */     this.diecount = _diecount_;
/* 18 */     this.killcount = _killcount_;
/* 19 */     this.revivetime = _revivetime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.diecount);
/* 28 */     _os_.marshal(this.killcount);
/* 29 */     _os_.marshal(this.revivetime);
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     this.diecount = _os_.unmarshal_int();
/* 35 */     this.killcount = _os_.unmarshal_int();
/* 36 */     this.revivetime = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof FightRecord)) {
/* 43 */       FightRecord _o_ = (FightRecord)_o1_;
/* 44 */       if (this.diecount != _o_.diecount) return false;
/* 45 */       if (this.killcount != _o_.killcount) return false;
/* 46 */       if (this.revivetime != _o_.revivetime) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.diecount;
/* 55 */     _h_ += this.killcount;
/* 56 */     _h_ += this.revivetime;
/* 57 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 61 */     StringBuilder _sb_ = new StringBuilder();
/* 62 */     _sb_.append("(");
/* 63 */     _sb_.append(this.diecount).append(",");
/* 64 */     _sb_.append(this.killcount).append(",");
/* 65 */     _sb_.append(this.revivetime).append(",");
/* 66 */     _sb_.append(")");
/* 67 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(FightRecord _o_) {
/* 71 */     if (_o_ == this) return 0;
/* 72 */     int _c_ = 0;
/* 73 */     _c_ = this.diecount - _o_.diecount;
/* 74 */     if (0 != _c_) return _c_;
/* 75 */     _c_ = this.killcount - _o_.killcount;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = this.revivetime - _o_.revivetime;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\FightRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */