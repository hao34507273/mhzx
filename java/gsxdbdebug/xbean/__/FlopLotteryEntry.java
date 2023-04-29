/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import mzm.gsp.floplottery.main.FlopLotteryHandlerInterface;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xbean.FlopLotteryAwardPoolResult;
/*     */ import xdb.Log;
/*     */ import xdb.LogKey;
/*     */ import xdb.Logs;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class FlopLotteryEntry extends XBean implements xbean.FlopLotteryEntry
/*     */ {
/*     */   private long uid;
/*     */   private int floplotterymaincfgid;
/*     */   private ArrayList<FlopLotteryAwardPoolResult> floplotteryawardpoolresultlist;
/*     */   private int isconddone;
/*     */   private long expiretimestamp;
/*     */   private FlopLotteryHandlerInterface floplotteryhandler;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  28 */     this.uid = 0L;
/*  29 */     this.floplotterymaincfgid = 0;
/*  30 */     this.floplotteryawardpoolresultlist.clear();
/*  31 */     this.isconddone = 0;
/*  32 */     this.expiretimestamp = 0L;
/*  33 */     this.floplotteryhandler = null;
/*     */   }
/*     */   
/*     */   FlopLotteryEntry(int __, XBean _xp_, String _vn_)
/*     */   {
/*  38 */     super(_xp_, _vn_);
/*  39 */     this.floplotteryawardpoolresultlist = new ArrayList();
/*  40 */     this.floplotteryhandler = null;
/*     */   }
/*     */   
/*     */   public FlopLotteryEntry()
/*     */   {
/*  45 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FlopLotteryEntry(FlopLotteryEntry _o_)
/*     */   {
/*  50 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FlopLotteryEntry(xbean.FlopLotteryEntry _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  55 */     super(_xp_, _vn_);
/*  56 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  62 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  68 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  74 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  80 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  86 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FlopLotteryEntry copy()
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*  93 */     return new FlopLotteryEntry(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FlopLotteryEntry toData()
/*     */   {
/*  99 */     _xdb_verify_unsafe_();
/* 100 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FlopLotteryEntry toBean()
/*     */   {
/* 105 */     _xdb_verify_unsafe_();
/* 106 */     return new FlopLotteryEntry(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FlopLotteryEntry toDataIf()
/*     */   {
/* 112 */     _xdb_verify_unsafe_();
/* 113 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FlopLotteryEntry toBeanIf()
/*     */   {
/* 118 */     _xdb_verify_unsafe_();
/* 119 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 125 */     _xdb_verify_unsafe_();
/* 126 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getUid()
/*     */   {
/* 133 */     _xdb_verify_unsafe_();
/* 134 */     return this.uid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getFloplotterymaincfgid()
/*     */   {
/* 141 */     _xdb_verify_unsafe_();
/* 142 */     return this.floplotterymaincfgid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.List<FlopLotteryAwardPoolResult> getFloplotteryawardpoolresultlist()
/*     */   {
/* 149 */     _xdb_verify_unsafe_();
/* 150 */     return Logs.logList(new LogKey(this, "floplotteryawardpoolresultlist"), this.floplotteryawardpoolresultlist);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getIsconddone()
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     return this.isconddone;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getExpiretimestamp()
/*     */   {
/* 165 */     _xdb_verify_unsafe_();
/* 166 */     return this.expiretimestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public FlopLotteryHandlerInterface getFloplotteryhandler()
/*     */   {
/* 173 */     _xdb_verify_unsafe_();
/* 174 */     return this.floplotteryhandler;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUid(long _v_)
/*     */   {
/* 181 */     _xdb_verify_unsafe_();
/* 182 */     Logs.logIf(new LogKey(this, "uid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 186 */         new xdb.logs.LogLong(this, FlopLotteryEntry.this.uid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 190 */             FlopLotteryEntry.this.uid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 194 */     });
/* 195 */     this.uid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFloplotterymaincfgid(int _v_)
/*     */   {
/* 202 */     _xdb_verify_unsafe_();
/* 203 */     Logs.logIf(new LogKey(this, "floplotterymaincfgid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 207 */         new xdb.logs.LogInt(this, FlopLotteryEntry.this.floplotterymaincfgid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 211 */             FlopLotteryEntry.this.floplotterymaincfgid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 215 */     });
/* 216 */     this.floplotterymaincfgid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIsconddone(int _v_)
/*     */   {
/* 223 */     _xdb_verify_unsafe_();
/* 224 */     Logs.logIf(new LogKey(this, "isconddone")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 228 */         new xdb.logs.LogInt(this, FlopLotteryEntry.this.isconddone)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 232 */             FlopLotteryEntry.this.isconddone = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 236 */     });
/* 237 */     this.isconddone = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setExpiretimestamp(long _v_)
/*     */   {
/* 244 */     _xdb_verify_unsafe_();
/* 245 */     Logs.logIf(new LogKey(this, "expiretimestamp")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 249 */         new xdb.logs.LogLong(this, FlopLotteryEntry.this.expiretimestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 253 */             FlopLotteryEntry.this.expiretimestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 257 */     });
/* 258 */     this.expiretimestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFloplotteryhandler(FlopLotteryHandlerInterface _v_)
/*     */   {
/* 265 */     _xdb_verify_unsafe_();
/* 266 */     Logs.logIf(new LogKey(this, "floplotteryhandler")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 270 */         new xdb.logs.LogObject(this, FlopLotteryEntry.this.floplotteryhandler)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 274 */             FlopLotteryEntry.this.floplotteryhandler = ((FlopLotteryHandlerInterface)this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 278 */     });
/* 279 */     this.floplotteryhandler = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 285 */     _xdb_verify_unsafe_();
/* 286 */     FlopLotteryEntry _o_ = null;
/* 287 */     if ((_o1_ instanceof FlopLotteryEntry)) { _o_ = (FlopLotteryEntry)_o1_;
/* 288 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 289 */       return false;
/* 290 */     if (this.uid != _o_.uid) return false;
/* 291 */     if (this.floplotterymaincfgid != _o_.floplotterymaincfgid) return false;
/* 292 */     if (!this.floplotteryawardpoolresultlist.equals(_o_.floplotteryawardpoolresultlist)) return false;
/* 293 */     if (this.isconddone != _o_.isconddone) return false;
/* 294 */     if (this.expiretimestamp != _o_.expiretimestamp) return false;
/* 295 */     if (((null == this.floplotteryhandler) && (null != _o_.floplotteryhandler)) || ((null != this.floplotteryhandler) && (null == _o_.floplotteryhandler)) || ((null != this.floplotteryhandler) && (null != _o_.floplotteryhandler) && (!this.floplotteryhandler.equals(_o_.floplotteryhandler)))) return false;
/* 296 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/* 303 */     int _h_ = 0;
/* 304 */     _h_ = (int)(_h_ + this.uid);
/* 305 */     _h_ += this.floplotterymaincfgid;
/* 306 */     _h_ += this.floplotteryawardpoolresultlist.hashCode();
/* 307 */     _h_ += this.isconddone;
/* 308 */     _h_ = (int)(_h_ + this.expiretimestamp);
/* 309 */     _h_ += (this.floplotteryhandler == null ? 0 : this.floplotteryhandler.hashCode());
/* 310 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 316 */     _xdb_verify_unsafe_();
/* 317 */     StringBuilder _sb_ = new StringBuilder();
/* 318 */     _sb_.append("(");
/* 319 */     _sb_.append(this.uid);
/* 320 */     _sb_.append(",");
/* 321 */     _sb_.append(this.floplotterymaincfgid);
/* 322 */     _sb_.append(",");
/* 323 */     _sb_.append(this.floplotteryawardpoolresultlist);
/* 324 */     _sb_.append(",");
/* 325 */     _sb_.append(this.isconddone);
/* 326 */     _sb_.append(",");
/* 327 */     _sb_.append(this.expiretimestamp);
/* 328 */     _sb_.append(",");
/* 329 */     _sb_.append(this.floplotteryhandler);
/* 330 */     _sb_.append(")");
/* 331 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 337 */     ListenableBean lb = new ListenableBean();
/* 338 */     lb.add(new ListenableChanged().setVarName("uid"));
/* 339 */     lb.add(new ListenableChanged().setVarName("floplotterymaincfgid"));
/* 340 */     lb.add(new ListenableChanged().setVarName("floplotteryawardpoolresultlist"));
/* 341 */     lb.add(new ListenableChanged().setVarName("isconddone"));
/* 342 */     lb.add(new ListenableChanged().setVarName("expiretimestamp"));
/* 343 */     lb.add(new ListenableChanged().setVarName("floplotteryhandler"));
/* 344 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FlopLotteryEntry {
/*     */     private Const() {}
/*     */     
/*     */     FlopLotteryEntry nThis() {
/* 351 */       return FlopLotteryEntry.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 357 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FlopLotteryEntry copy()
/*     */     {
/* 363 */       return FlopLotteryEntry.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FlopLotteryEntry toData()
/*     */     {
/* 369 */       return FlopLotteryEntry.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FlopLotteryEntry toBean()
/*     */     {
/* 374 */       return FlopLotteryEntry.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FlopLotteryEntry toDataIf()
/*     */     {
/* 380 */       return FlopLotteryEntry.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FlopLotteryEntry toBeanIf()
/*     */     {
/* 385 */       return FlopLotteryEntry.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getUid()
/*     */     {
/* 392 */       FlopLotteryEntry.this._xdb_verify_unsafe_();
/* 393 */       return FlopLotteryEntry.this.uid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getFloplotterymaincfgid()
/*     */     {
/* 400 */       FlopLotteryEntry.this._xdb_verify_unsafe_();
/* 401 */       return FlopLotteryEntry.this.floplotterymaincfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.List<FlopLotteryAwardPoolResult> getFloplotteryawardpoolresultlist()
/*     */     {
/* 408 */       FlopLotteryEntry.this._xdb_verify_unsafe_();
/* 409 */       return xdb.Consts.constList(FlopLotteryEntry.this.floplotteryawardpoolresultlist);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getIsconddone()
/*     */     {
/* 416 */       FlopLotteryEntry.this._xdb_verify_unsafe_();
/* 417 */       return FlopLotteryEntry.this.isconddone;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getExpiretimestamp()
/*     */     {
/* 424 */       FlopLotteryEntry.this._xdb_verify_unsafe_();
/* 425 */       return FlopLotteryEntry.this.expiretimestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public FlopLotteryHandlerInterface getFloplotteryhandler()
/*     */     {
/* 432 */       FlopLotteryEntry.this._xdb_verify_unsafe_();
/* 433 */       return FlopLotteryEntry.this.floplotteryhandler;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUid(long _v_)
/*     */     {
/* 440 */       FlopLotteryEntry.this._xdb_verify_unsafe_();
/* 441 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFloplotterymaincfgid(int _v_)
/*     */     {
/* 448 */       FlopLotteryEntry.this._xdb_verify_unsafe_();
/* 449 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIsconddone(int _v_)
/*     */     {
/* 456 */       FlopLotteryEntry.this._xdb_verify_unsafe_();
/* 457 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setExpiretimestamp(long _v_)
/*     */     {
/* 464 */       FlopLotteryEntry.this._xdb_verify_unsafe_();
/* 465 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFloplotteryhandler(FlopLotteryHandlerInterface _v_)
/*     */     {
/* 472 */       FlopLotteryEntry.this._xdb_verify_unsafe_();
/* 473 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 479 */       FlopLotteryEntry.this._xdb_verify_unsafe_();
/* 480 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 486 */       FlopLotteryEntry.this._xdb_verify_unsafe_();
/* 487 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 493 */       return FlopLotteryEntry.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 499 */       return FlopLotteryEntry.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 505 */       FlopLotteryEntry.this._xdb_verify_unsafe_();
/* 506 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 512 */       return FlopLotteryEntry.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 518 */       return FlopLotteryEntry.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 524 */       FlopLotteryEntry.this._xdb_verify_unsafe_();
/* 525 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 531 */       return FlopLotteryEntry.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 537 */       return FlopLotteryEntry.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 543 */       return FlopLotteryEntry.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 549 */       return FlopLotteryEntry.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 555 */       return FlopLotteryEntry.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 561 */       return FlopLotteryEntry.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 567 */       return FlopLotteryEntry.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FlopLotteryEntry
/*     */   {
/*     */     private long uid;
/*     */     
/*     */     private int floplotterymaincfgid;
/*     */     
/*     */     private ArrayList<FlopLotteryAwardPoolResult> floplotteryawardpoolresultlist;
/*     */     
/*     */     private int isconddone;
/*     */     
/*     */     private long expiretimestamp;
/*     */     
/*     */     private FlopLotteryHandlerInterface floplotteryhandler;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 589 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 594 */       this.floplotteryawardpoolresultlist = new ArrayList();
/* 595 */       this.floplotteryhandler = null;
/*     */     }
/*     */     
/*     */     Data(xbean.FlopLotteryEntry _o1_)
/*     */     {
/* 600 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 606 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 612 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 618 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 624 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 630 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FlopLotteryEntry copy()
/*     */     {
/* 636 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FlopLotteryEntry toData()
/*     */     {
/* 642 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FlopLotteryEntry toBean()
/*     */     {
/* 647 */       return new FlopLotteryEntry(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FlopLotteryEntry toDataIf()
/*     */     {
/* 653 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FlopLotteryEntry toBeanIf()
/*     */     {
/* 658 */       return new FlopLotteryEntry(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 664 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 668 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 672 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 676 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 680 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 684 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 688 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getUid()
/*     */     {
/* 695 */       return this.uid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getFloplotterymaincfgid()
/*     */     {
/* 702 */       return this.floplotterymaincfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.List<FlopLotteryAwardPoolResult> getFloplotteryawardpoolresultlist()
/*     */     {
/* 709 */       return this.floplotteryawardpoolresultlist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getIsconddone()
/*     */     {
/* 716 */       return this.isconddone;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getExpiretimestamp()
/*     */     {
/* 723 */       return this.expiretimestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public FlopLotteryHandlerInterface getFloplotteryhandler()
/*     */     {
/* 730 */       return this.floplotteryhandler;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUid(long _v_)
/*     */     {
/* 737 */       this.uid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFloplotterymaincfgid(int _v_)
/*     */     {
/* 744 */       this.floplotterymaincfgid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIsconddone(int _v_)
/*     */     {
/* 751 */       this.isconddone = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setExpiretimestamp(long _v_)
/*     */     {
/* 758 */       this.expiretimestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFloplotteryhandler(FlopLotteryHandlerInterface _v_)
/*     */     {
/* 765 */       this.floplotteryhandler = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 771 */       if (!(_o1_ instanceof Data)) return false;
/* 772 */       Data _o_ = (Data)_o1_;
/* 773 */       if (this.uid != _o_.uid) return false;
/* 774 */       if (this.floplotterymaincfgid != _o_.floplotterymaincfgid) return false;
/* 775 */       if (!this.floplotteryawardpoolresultlist.equals(_o_.floplotteryawardpoolresultlist)) return false;
/* 776 */       if (this.isconddone != _o_.isconddone) return false;
/* 777 */       if (this.expiretimestamp != _o_.expiretimestamp) return false;
/* 778 */       if (((null == this.floplotteryhandler) && (null != _o_.floplotteryhandler)) || ((null != this.floplotteryhandler) && (null == _o_.floplotteryhandler)) || ((null != this.floplotteryhandler) && (null != _o_.floplotteryhandler) && (!this.floplotteryhandler.equals(_o_.floplotteryhandler)))) return false;
/* 779 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 785 */       int _h_ = 0;
/* 786 */       _h_ = (int)(_h_ + this.uid);
/* 787 */       _h_ += this.floplotterymaincfgid;
/* 788 */       _h_ += this.floplotteryawardpoolresultlist.hashCode();
/* 789 */       _h_ += this.isconddone;
/* 790 */       _h_ = (int)(_h_ + this.expiretimestamp);
/* 791 */       _h_ += (this.floplotteryhandler == null ? 0 : this.floplotteryhandler.hashCode());
/* 792 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 798 */       StringBuilder _sb_ = new StringBuilder();
/* 799 */       _sb_.append("(");
/* 800 */       _sb_.append(this.uid);
/* 801 */       _sb_.append(",");
/* 802 */       _sb_.append(this.floplotterymaincfgid);
/* 803 */       _sb_.append(",");
/* 804 */       _sb_.append(this.floplotteryawardpoolresultlist);
/* 805 */       _sb_.append(",");
/* 806 */       _sb_.append(this.isconddone);
/* 807 */       _sb_.append(",");
/* 808 */       _sb_.append(this.expiretimestamp);
/* 809 */       _sb_.append(",");
/* 810 */       _sb_.append(this.floplotteryhandler);
/* 811 */       _sb_.append(")");
/* 812 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FlopLotteryEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */