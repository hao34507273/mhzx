/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class CrossCompeteAgainst
/*    */   implements Marshal
/*    */ {
/*    */   public CrossCompeteAgainstFaction front_faction;
/*    */   public CrossCompeteAgainstFaction behind_faction;
/*    */   public int compete_index;
/*    */   
/*    */   public CrossCompeteAgainst()
/*    */   {
/* 16 */     this.front_faction = new CrossCompeteAgainstFaction();
/* 17 */     this.behind_faction = new CrossCompeteAgainstFaction();
/*    */   }
/*    */   
/*    */   public CrossCompeteAgainst(CrossCompeteAgainstFaction _front_faction_, CrossCompeteAgainstFaction _behind_faction_, int _compete_index_) {
/* 21 */     this.front_faction = _front_faction_;
/* 22 */     this.behind_faction = _behind_faction_;
/* 23 */     this.compete_index = _compete_index_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     if (!this.front_faction._validator_()) return false;
/* 28 */     if (!this.behind_faction._validator_()) return false;
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.front_faction);
/* 34 */     _os_.marshal(this.behind_faction);
/* 35 */     _os_.marshal(this.compete_index);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.front_faction.unmarshal(_os_);
/* 41 */     this.behind_faction.unmarshal(_os_);
/* 42 */     this.compete_index = _os_.unmarshal_int();
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof CrossCompeteAgainst)) {
/* 49 */       CrossCompeteAgainst _o_ = (CrossCompeteAgainst)_o1_;
/* 50 */       if (!this.front_faction.equals(_o_.front_faction)) return false;
/* 51 */       if (!this.behind_faction.equals(_o_.behind_faction)) return false;
/* 52 */       if (this.compete_index != _o_.compete_index) return false;
/* 53 */       return true;
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 59 */     int _h_ = 0;
/* 60 */     _h_ += this.front_faction.hashCode();
/* 61 */     _h_ += this.behind_faction.hashCode();
/* 62 */     _h_ += this.compete_index;
/* 63 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 67 */     StringBuilder _sb_ = new StringBuilder();
/* 68 */     _sb_.append("(");
/* 69 */     _sb_.append(this.front_faction).append(",");
/* 70 */     _sb_.append(this.behind_faction).append(",");
/* 71 */     _sb_.append(this.compete_index).append(",");
/* 72 */     _sb_.append(")");
/* 73 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\CrossCompeteAgainst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */