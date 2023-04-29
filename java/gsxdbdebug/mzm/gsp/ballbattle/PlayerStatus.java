/*    */ package mzm.gsp.ballbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashSet;
/*    */ 
/*    */ public class PlayerStatus implements Marshal
/*    */ {
/*    */   public int level;
/*    */   public int gene;
/*    */   public HashSet<Integer> states;
/*    */   
/*    */   public PlayerStatus()
/*    */   {
/* 16 */     this.states = new HashSet();
/*    */   }
/*    */   
/*    */   public PlayerStatus(int _level_, int _gene_, HashSet<Integer> _states_) {
/* 20 */     this.level = _level_;
/* 21 */     this.gene = _gene_;
/* 22 */     this.states = _states_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.level);
/* 31 */     _os_.marshal(this.gene);
/* 32 */     _os_.compact_uint32(this.states.size());
/* 33 */     for (Integer _v_ : this.states) {
/* 34 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.level = _os_.unmarshal_int();
/* 41 */     this.gene = _os_.unmarshal_int();
/* 42 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 44 */       int _v_ = _os_.unmarshal_int();
/* 45 */       this.states.add(Integer.valueOf(_v_));
/*    */     }
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof PlayerStatus)) {
/* 53 */       PlayerStatus _o_ = (PlayerStatus)_o1_;
/* 54 */       if (this.level != _o_.level) return false;
/* 55 */       if (this.gene != _o_.gene) return false;
/* 56 */       if (!this.states.equals(_o_.states)) return false;
/* 57 */       return true;
/*    */     }
/* 59 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 63 */     int _h_ = 0;
/* 64 */     _h_ += this.level;
/* 65 */     _h_ += this.gene;
/* 66 */     _h_ += this.states.hashCode();
/* 67 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuilder _sb_ = new StringBuilder();
/* 72 */     _sb_.append("(");
/* 73 */     _sb_.append(this.level).append(",");
/* 74 */     _sb_.append(this.gene).append(",");
/* 75 */     _sb_.append(this.states).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\PlayerStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */