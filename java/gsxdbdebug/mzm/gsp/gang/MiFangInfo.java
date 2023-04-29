/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class MiFangInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public ArrayList<Integer> itemlist;
/*    */   public int cfgid;
/*    */   public long endtime;
/*    */   public int usecount;
/*    */   public int totalcount;
/*    */   
/*    */   public MiFangInfo()
/*    */   {
/* 16 */     this.itemlist = new ArrayList();
/*    */   }
/*    */   
/*    */   public MiFangInfo(ArrayList<Integer> _itemlist_, int _cfgid_, long _endtime_, int _usecount_, int _totalcount_) {
/* 20 */     this.itemlist = _itemlist_;
/* 21 */     this.cfgid = _cfgid_;
/* 22 */     this.endtime = _endtime_;
/* 23 */     this.usecount = _usecount_;
/* 24 */     this.totalcount = _totalcount_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.compact_uint32(this.itemlist.size());
/* 33 */     for (Integer _v_ : this.itemlist) {
/* 34 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 36 */     _os_.marshal(this.cfgid);
/* 37 */     _os_.marshal(this.endtime);
/* 38 */     _os_.marshal(this.usecount);
/* 39 */     _os_.marshal(this.totalcount);
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 44 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 46 */       int _v_ = _os_.unmarshal_int();
/* 47 */       this.itemlist.add(Integer.valueOf(_v_));
/*    */     }
/* 49 */     this.cfgid = _os_.unmarshal_int();
/* 50 */     this.endtime = _os_.unmarshal_long();
/* 51 */     this.usecount = _os_.unmarshal_int();
/* 52 */     this.totalcount = _os_.unmarshal_int();
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof MiFangInfo)) {
/* 59 */       MiFangInfo _o_ = (MiFangInfo)_o1_;
/* 60 */       if (!this.itemlist.equals(_o_.itemlist)) return false;
/* 61 */       if (this.cfgid != _o_.cfgid) return false;
/* 62 */       if (this.endtime != _o_.endtime) return false;
/* 63 */       if (this.usecount != _o_.usecount) return false;
/* 64 */       if (this.totalcount != _o_.totalcount) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += this.itemlist.hashCode();
/* 73 */     _h_ += this.cfgid;
/* 74 */     _h_ += (int)this.endtime;
/* 75 */     _h_ += this.usecount;
/* 76 */     _h_ += this.totalcount;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.itemlist).append(",");
/* 84 */     _sb_.append(this.cfgid).append(",");
/* 85 */     _sb_.append(this.endtime).append(",");
/* 86 */     _sb_.append(this.usecount).append(",");
/* 87 */     _sb_.append(this.totalcount).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\MiFangInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */