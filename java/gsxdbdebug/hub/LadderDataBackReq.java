/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class LadderDataBackReq
/*    */   implements Marshal
/*    */ {
/*    */   public static final int WIN = 0;
/*    */   public static final int LOSE = 1;
/*    */   public ArrayList<LadderUserDataBack> ladderuserbackdatas;
/*    */   public FightResult fightresult;
/*    */   public int winorlose;
/*    */   
/*    */   public LadderDataBackReq()
/*    */   {
/* 19 */     this.ladderuserbackdatas = new ArrayList();
/* 20 */     this.fightresult = new FightResult();
/*    */   }
/*    */   
/*    */   public LadderDataBackReq(ArrayList<LadderUserDataBack> _ladderuserbackdatas_, FightResult _fightresult_, int _winorlose_) {
/* 24 */     this.ladderuserbackdatas = _ladderuserbackdatas_;
/* 25 */     this.fightresult = _fightresult_;
/* 26 */     this.winorlose = _winorlose_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 30 */     for (LadderUserDataBack _v_ : this.ladderuserbackdatas)
/* 31 */       if (!_v_._validator_()) return false;
/* 32 */     if (!this.fightresult._validator_()) return false;
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 37 */     _os_.compact_uint32(this.ladderuserbackdatas.size());
/* 38 */     for (LadderUserDataBack _v_ : this.ladderuserbackdatas) {
/* 39 */       _os_.marshal(_v_);
/*    */     }
/* 41 */     _os_.marshal(this.fightresult);
/* 42 */     _os_.marshal(this.winorlose);
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 47 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 48 */       LadderUserDataBack _v_ = new LadderUserDataBack();
/* 49 */       _v_.unmarshal(_os_);
/* 50 */       this.ladderuserbackdatas.add(_v_);
/*    */     }
/* 52 */     this.fightresult.unmarshal(_os_);
/* 53 */     this.winorlose = _os_.unmarshal_int();
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof LadderDataBackReq)) {
/* 60 */       LadderDataBackReq _o_ = (LadderDataBackReq)_o1_;
/* 61 */       if (!this.ladderuserbackdatas.equals(_o_.ladderuserbackdatas)) return false;
/* 62 */       if (!this.fightresult.equals(_o_.fightresult)) return false;
/* 63 */       if (this.winorlose != _o_.winorlose) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.ladderuserbackdatas.hashCode();
/* 72 */     _h_ += this.fightresult.hashCode();
/* 73 */     _h_ += this.winorlose;
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.ladderuserbackdatas).append(",");
/* 81 */     _sb_.append(this.fightresult).append(",");
/* 82 */     _sb_.append(this.winorlose).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\LadderDataBackReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */