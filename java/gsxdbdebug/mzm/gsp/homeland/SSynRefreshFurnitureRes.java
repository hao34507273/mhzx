/*    */ package mzm.gsp.homeland;
/*    */ 
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
/*    */ public class SSynRefreshFurnitureRes
/*    */   extends __SSynRefreshFurnitureRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605462;
/*    */   public int dayrefreshcount;
/*    */   public HashMap<Integer, Integer> canbuyitems;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12605462;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynRefreshFurnitureRes()
/*    */   {
/* 32 */     this.canbuyitems = new HashMap();
/*    */   }
/*    */   
/*    */   public SSynRefreshFurnitureRes(int _dayrefreshcount_, HashMap<Integer, Integer> _canbuyitems_) {
/* 36 */     this.dayrefreshcount = _dayrefreshcount_;
/* 37 */     this.canbuyitems = _canbuyitems_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.dayrefreshcount);
/* 46 */     _os_.compact_uint32(this.canbuyitems.size());
/* 47 */     for (Map.Entry<Integer, Integer> _e_ : this.canbuyitems.entrySet()) {
/* 48 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 49 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.dayrefreshcount = _os_.unmarshal_int();
/* 56 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 58 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 60 */       int _v_ = _os_.unmarshal_int();
/* 61 */       this.canbuyitems.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof SSynRefreshFurnitureRes)) {
/* 72 */       SSynRefreshFurnitureRes _o_ = (SSynRefreshFurnitureRes)_o1_;
/* 73 */       if (this.dayrefreshcount != _o_.dayrefreshcount) return false;
/* 74 */       if (!this.canbuyitems.equals(_o_.canbuyitems)) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.dayrefreshcount;
/* 83 */     _h_ += this.canbuyitems.hashCode();
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.dayrefreshcount).append(",");
/* 91 */     _sb_.append(this.canbuyitems).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\SSynRefreshFurnitureRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */