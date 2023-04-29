/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class CrossCompeteRoamServersRsp implements Marshal
/*    */ {
/*    */   public long start_millis;
/*    */   public HashMap<Integer, Integer> compete2zoneid;
/*    */   
/*    */   public CrossCompeteRoamServersRsp()
/*    */   {
/* 15 */     this.compete2zoneid = new HashMap();
/*    */   }
/*    */   
/*    */   public CrossCompeteRoamServersRsp(long _start_millis_, HashMap<Integer, Integer> _compete2zoneid_) {
/* 19 */     this.start_millis = _start_millis_;
/* 20 */     this.compete2zoneid = _compete2zoneid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.start_millis);
/* 29 */     _os_.compact_uint32(this.compete2zoneid.size());
/* 30 */     for (Map.Entry<Integer, Integer> _e_ : this.compete2zoneid.entrySet()) {
/* 31 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 32 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 38 */     this.start_millis = _os_.unmarshal_long();
/* 39 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 41 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 43 */       int _v_ = _os_.unmarshal_int();
/* 44 */       this.compete2zoneid.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 50 */     if (_o1_ == this) return true;
/* 51 */     if ((_o1_ instanceof CrossCompeteRoamServersRsp)) {
/* 52 */       CrossCompeteRoamServersRsp _o_ = (CrossCompeteRoamServersRsp)_o1_;
/* 53 */       if (this.start_millis != _o_.start_millis) return false;
/* 54 */       if (!this.compete2zoneid.equals(_o_.compete2zoneid)) return false;
/* 55 */       return true;
/*    */     }
/* 57 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 61 */     int _h_ = 0;
/* 62 */     _h_ += (int)this.start_millis;
/* 63 */     _h_ += this.compete2zoneid.hashCode();
/* 64 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 68 */     StringBuilder _sb_ = new StringBuilder();
/* 69 */     _sb_.append("(");
/* 70 */     _sb_.append(this.start_millis).append(",");
/* 71 */     _sb_.append(this.compete2zoneid).append(",");
/* 72 */     _sb_.append(")");
/* 73 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\CrossCompeteRoamServersRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */