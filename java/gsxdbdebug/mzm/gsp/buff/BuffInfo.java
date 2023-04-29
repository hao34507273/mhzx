/*    */ package mzm.gsp.buff;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ public class BuffInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public static final int RATE = 0;
/*    */   public static final int TIME = 1;
/*    */   public int buffid;
/*    */   public long typevalue;
/*    */   public HashMap<Integer, Long> idipbuffinfo;
/*    */   
/*    */   public BuffInfo()
/*    */   {
/* 17 */     this.idipbuffinfo = new HashMap();
/*    */   }
/*    */   
/*    */   public BuffInfo(int _buffid_, long _typevalue_, HashMap<Integer, Long> _idipbuffinfo_) {
/* 21 */     this.buffid = _buffid_;
/* 22 */     this.typevalue = _typevalue_;
/* 23 */     this.idipbuffinfo = _idipbuffinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.buffid);
/* 32 */     _os_.marshal(this.typevalue);
/* 33 */     _os_.compact_uint32(this.idipbuffinfo.size());
/* 34 */     for (Map.Entry<Integer, Long> _e_ : this.idipbuffinfo.entrySet()) {
/* 35 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 36 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*    */     }
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 42 */     this.buffid = _os_.unmarshal_int();
/* 43 */     this.typevalue = _os_.unmarshal_long();
/* 44 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 46 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 48 */       long _v_ = _os_.unmarshal_long();
/* 49 */       this.idipbuffinfo.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 55 */     if (_o1_ == this) return true;
/* 56 */     if ((_o1_ instanceof BuffInfo)) {
/* 57 */       BuffInfo _o_ = (BuffInfo)_o1_;
/* 58 */       if (this.buffid != _o_.buffid) return false;
/* 59 */       if (this.typevalue != _o_.typevalue) return false;
/* 60 */       if (!this.idipbuffinfo.equals(_o_.idipbuffinfo)) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += this.buffid;
/* 69 */     _h_ += (int)this.typevalue;
/* 70 */     _h_ += this.idipbuffinfo.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.buffid).append(",");
/* 78 */     _sb_.append(this.typevalue).append(",");
/* 79 */     _sb_.append(this.idipbuffinfo).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\BuffInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */