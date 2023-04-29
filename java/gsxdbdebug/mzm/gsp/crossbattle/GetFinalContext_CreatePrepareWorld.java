/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class GetFinalContext_CreatePrepareWorld
/*    */   implements Marshal, Comparable<GetFinalContext_CreatePrepareWorld>
/*    */ {
/*    */   public long corps_id;
/*    */   public int final_stage;
/*    */   
/*    */   public GetFinalContext_CreatePrepareWorld() {}
/*    */   
/*    */   public GetFinalContext_CreatePrepareWorld(long _corps_id_, int _final_stage_)
/*    */   {
/* 18 */     this.corps_id = _corps_id_;
/* 19 */     this.final_stage = _final_stage_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.corps_id);
/* 28 */     _os_.marshal(this.final_stage);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.corps_id = _os_.unmarshal_long();
/* 34 */     this.final_stage = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof GetFinalContext_CreatePrepareWorld)) {
/* 41 */       GetFinalContext_CreatePrepareWorld _o_ = (GetFinalContext_CreatePrepareWorld)_o1_;
/* 42 */       if (this.corps_id != _o_.corps_id) return false;
/* 43 */       if (this.final_stage != _o_.final_stage) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += (int)this.corps_id;
/* 52 */     _h_ += this.final_stage;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.corps_id).append(",");
/* 60 */     _sb_.append(this.final_stage).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(GetFinalContext_CreatePrepareWorld _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = Long.signum(this.corps_id - _o_.corps_id);
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.final_stage - _o_.final_stage;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\GetFinalContext_CreatePrepareWorld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */