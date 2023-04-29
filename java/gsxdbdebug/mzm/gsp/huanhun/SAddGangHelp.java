/*    */ package mzm.gsp.huanhun;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SAddGangHelp
/*    */   extends __SAddGangHelp__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584466;
/*    */   public long roleid;
/*    */   public HashMap<Integer, BoxData> boxindex2data;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12584466;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SAddGangHelp()
/*    */   {
/* 34 */     this.boxindex2data = new HashMap();
/*    */   }
/*    */   
/*    */   public SAddGangHelp(long _roleid_, HashMap<Integer, BoxData> _boxindex2data_) {
/* 38 */     this.roleid = _roleid_;
/* 39 */     this.boxindex2data = _boxindex2data_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (Map.Entry<Integer, BoxData> _e_ : this.boxindex2data.entrySet()) {
/* 44 */       if (!((BoxData)_e_.getValue())._validator_()) return false;
/*    */     }
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.roleid);
/* 51 */     _os_.compact_uint32(this.boxindex2data.size());
/* 52 */     for (Map.Entry<Integer, BoxData> _e_ : this.boxindex2data.entrySet()) {
/* 53 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 54 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     this.roleid = _os_.unmarshal_long();
/* 61 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 63 */       int _k_ = _os_.unmarshal_int();
/* 64 */       BoxData _v_ = new BoxData();
/* 65 */       _v_.unmarshal(_os_);
/* 66 */       this.boxindex2data.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 68 */     if (!_validator_()) {
/* 69 */       throw new VerifyError("validator failed");
/*    */     }
/* 71 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 75 */     if (_o1_ == this) return true;
/* 76 */     if ((_o1_ instanceof SAddGangHelp)) {
/* 77 */       SAddGangHelp _o_ = (SAddGangHelp)_o1_;
/* 78 */       if (this.roleid != _o_.roleid) return false;
/* 79 */       if (!this.boxindex2data.equals(_o_.boxindex2data)) return false;
/* 80 */       return true;
/*    */     }
/* 82 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 86 */     int _h_ = 0;
/* 87 */     _h_ += (int)this.roleid;
/* 88 */     _h_ += this.boxindex2data.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.roleid).append(",");
/* 96 */     _sb_.append(this.boxindex2data).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\SAddGangHelp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */