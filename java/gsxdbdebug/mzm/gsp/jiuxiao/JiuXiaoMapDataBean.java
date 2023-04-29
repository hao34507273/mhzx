/*    */ package mzm.gsp.jiuxiao;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class JiuXiaoMapDataBean implements Marshal
/*    */ {
/*    */   public static final int NOT_AWARD = 0;
/*    */   public static final int AWARDED = 1;
/*    */   public int awarded;
/*    */   public int cfgid;
/*    */   public ArrayList<Integer> processes;
/*    */   
/*    */   public JiuXiaoMapDataBean()
/*    */   {
/* 17 */     this.processes = new ArrayList();
/*    */   }
/*    */   
/*    */   public JiuXiaoMapDataBean(int _awarded_, int _cfgid_, ArrayList<Integer> _processes_) {
/* 21 */     this.awarded = _awarded_;
/* 22 */     this.cfgid = _cfgid_;
/* 23 */     this.processes = _processes_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.awarded);
/* 32 */     _os_.marshal(this.cfgid);
/* 33 */     _os_.compact_uint32(this.processes.size());
/* 34 */     for (Integer _v_ : this.processes) {
/* 35 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 41 */     this.awarded = _os_.unmarshal_int();
/* 42 */     this.cfgid = _os_.unmarshal_int();
/* 43 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 45 */       int _v_ = _os_.unmarshal_int();
/* 46 */       this.processes.add(Integer.valueOf(_v_));
/*    */     }
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 52 */     if (_o1_ == this) return true;
/* 53 */     if ((_o1_ instanceof JiuXiaoMapDataBean)) {
/* 54 */       JiuXiaoMapDataBean _o_ = (JiuXiaoMapDataBean)_o1_;
/* 55 */       if (this.awarded != _o_.awarded) return false;
/* 56 */       if (this.cfgid != _o_.cfgid) return false;
/* 57 */       if (!this.processes.equals(_o_.processes)) return false;
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     int _h_ = 0;
/* 65 */     _h_ += this.awarded;
/* 66 */     _h_ += this.cfgid;
/* 67 */     _h_ += this.processes.hashCode();
/* 68 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 72 */     StringBuilder _sb_ = new StringBuilder();
/* 73 */     _sb_.append("(");
/* 74 */     _sb_.append(this.awarded).append(",");
/* 75 */     _sb_.append(this.cfgid).append(",");
/* 76 */     _sb_.append(this.processes).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\JiuXiaoMapDataBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */