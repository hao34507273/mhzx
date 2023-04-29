/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ 
/*     */ public final class YaoDian extends XBean implements xbean.YaoDian
/*     */ {
/*     */   private int level;
/*     */   private long levelupendtime;
/*     */   private HashMap<Integer, Integer> yaocaimap;
/*     */   private xbean.MiFang mifang;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.level = 0;
/*  25 */     this.levelupendtime = 0L;
/*  26 */     this.yaocaimap.clear();
/*  27 */     this.mifang._reset_unsafe_();
/*     */   }
/*     */   
/*     */   YaoDian(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.yaocaimap = new HashMap();
/*  34 */     this.mifang = new MiFang(0, this, "mifang");
/*     */   }
/*     */   
/*     */   public YaoDian()
/*     */   {
/*  39 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public YaoDian(YaoDian _o_)
/*     */   {
/*  44 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   YaoDian(xbean.YaoDian _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  49 */     super(_xp_, _vn_);
/*  50 */     if ((_o1_ instanceof YaoDian)) { assign((YaoDian)_o1_);
/*  51 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  52 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  53 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(YaoDian _o_) {
/*  58 */     _o_._xdb_verify_unsafe_();
/*  59 */     this.level = _o_.level;
/*  60 */     this.levelupendtime = _o_.levelupendtime;
/*  61 */     this.yaocaimap = new HashMap();
/*  62 */     for (Map.Entry<Integer, Integer> _e_ : _o_.yaocaimap.entrySet())
/*  63 */       this.yaocaimap.put(_e_.getKey(), _e_.getValue());
/*  64 */     this.mifang = new MiFang(_o_.mifang, this, "mifang");
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  69 */     this.level = _o_.level;
/*  70 */     this.levelupendtime = _o_.levelupendtime;
/*  71 */     this.yaocaimap = new HashMap();
/*  72 */     for (Map.Entry<Integer, Integer> _e_ : _o_.yaocaimap.entrySet())
/*  73 */       this.yaocaimap.put(_e_.getKey(), _e_.getValue());
/*  74 */     this.mifang = new MiFang(_o_.mifang, this, "mifang");
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     _os_.marshal(this.level);
/*  82 */     _os_.marshal(this.levelupendtime);
/*  83 */     _os_.compact_uint32(this.yaocaimap.size());
/*  84 */     for (Map.Entry<Integer, Integer> _e_ : this.yaocaimap.entrySet())
/*     */     {
/*  86 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  87 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  89 */     this.mifang.marshal(_os_);
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     this.level = _os_.unmarshal_int();
/*  98 */     this.levelupendtime = _os_.unmarshal_long();
/*     */     
/* 100 */     int size = _os_.uncompact_uint32();
/* 101 */     if (size >= 12)
/*     */     {
/* 103 */       this.yaocaimap = new HashMap(size * 2);
/*     */     }
/* 105 */     for (; size > 0; size--)
/*     */     {
/* 107 */       int _k_ = 0;
/* 108 */       _k_ = _os_.unmarshal_int();
/* 109 */       int _v_ = 0;
/* 110 */       _v_ = _os_.unmarshal_int();
/* 111 */       this.yaocaimap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 114 */     this.mifang.unmarshal(_os_);
/* 115 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 121 */     _xdb_verify_unsafe_();
/* 122 */     int _size_ = 0;
/* 123 */     _size_ += CodedOutputStream.computeInt32Size(1, this.level);
/* 124 */     _size_ += CodedOutputStream.computeInt64Size(2, this.levelupendtime);
/* 125 */     for (Map.Entry<Integer, Integer> _e_ : this.yaocaimap.entrySet())
/*     */     {
/* 127 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 128 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 130 */     _size_ += CodedOutputStream.computeMessageSize(4, this.mifang);
/* 131 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 137 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 140 */       _output_.writeInt32(1, this.level);
/* 141 */       _output_.writeInt64(2, this.levelupendtime);
/* 142 */       for (Map.Entry<Integer, Integer> _e_ : this.yaocaimap.entrySet())
/*     */       {
/* 144 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 145 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 147 */       _output_.writeMessage(4, this.mifang);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 151 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 153 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 159 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 162 */       boolean done = false;
/* 163 */       while (!done)
/*     */       {
/* 165 */         int tag = _input_.readTag();
/* 166 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 170 */           done = true;
/* 171 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 175 */           this.level = _input_.readInt32();
/* 176 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 180 */           this.levelupendtime = _input_.readInt64();
/* 181 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 185 */           int _k_ = 0;
/* 186 */           _k_ = _input_.readInt32();
/* 187 */           int readTag = _input_.readTag();
/* 188 */           if (24 != readTag)
/*     */           {
/* 190 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 192 */           int _v_ = 0;
/* 193 */           _v_ = _input_.readInt32();
/* 194 */           this.yaocaimap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 195 */           break;
/*     */         
/*     */ 
/*     */         case 34: 
/* 199 */           _input_.readMessage(this.mifang);
/* 200 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 204 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 206 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 215 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 219 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 221 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.YaoDian copy()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     return new YaoDian(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.YaoDian toData()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.YaoDian toBean()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return new YaoDian(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.YaoDian toDataIf()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/* 248 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.YaoDian toBeanIf()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getLevel()
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     return this.level;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getLevelupendtime()
/*     */   {
/* 276 */     _xdb_verify_unsafe_();
/* 277 */     return this.levelupendtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getYaocaimap()
/*     */   {
/* 284 */     _xdb_verify_unsafe_();
/* 285 */     return xdb.Logs.logMap(new LogKey(this, "yaocaimap"), this.yaocaimap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getYaocaimapAsData()
/*     */   {
/* 292 */     _xdb_verify_unsafe_();
/*     */     
/* 294 */     YaoDian _o_ = this;
/* 295 */     Map<Integer, Integer> yaocaimap = new HashMap();
/* 296 */     for (Map.Entry<Integer, Integer> _e_ : _o_.yaocaimap.entrySet())
/* 297 */       yaocaimap.put(_e_.getKey(), _e_.getValue());
/* 298 */     return yaocaimap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public xbean.MiFang getMifang()
/*     */   {
/* 305 */     _xdb_verify_unsafe_();
/* 306 */     return this.mifang;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLevel(int _v_)
/*     */   {
/* 313 */     _xdb_verify_unsafe_();
/* 314 */     xdb.Logs.logIf(new LogKey(this, "level")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 318 */         new xdb.logs.LogInt(this, YaoDian.this.level)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 322 */             YaoDian.this.level = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 326 */     });
/* 327 */     this.level = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLevelupendtime(long _v_)
/*     */   {
/* 334 */     _xdb_verify_unsafe_();
/* 335 */     xdb.Logs.logIf(new LogKey(this, "levelupendtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 339 */         new xdb.logs.LogLong(this, YaoDian.this.levelupendtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 343 */             YaoDian.this.levelupendtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 347 */     });
/* 348 */     this.levelupendtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 354 */     _xdb_verify_unsafe_();
/* 355 */     YaoDian _o_ = null;
/* 356 */     if ((_o1_ instanceof YaoDian)) { _o_ = (YaoDian)_o1_;
/* 357 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 358 */       return false;
/* 359 */     if (this.level != _o_.level) return false;
/* 360 */     if (this.levelupendtime != _o_.levelupendtime) return false;
/* 361 */     if (!this.yaocaimap.equals(_o_.yaocaimap)) return false;
/* 362 */     if (!this.mifang.equals(_o_.mifang)) return false;
/* 363 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 369 */     _xdb_verify_unsafe_();
/* 370 */     int _h_ = 0;
/* 371 */     _h_ += this.level;
/* 372 */     _h_ = (int)(_h_ + this.levelupendtime);
/* 373 */     _h_ += this.yaocaimap.hashCode();
/* 374 */     _h_ += this.mifang.hashCode();
/* 375 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 381 */     _xdb_verify_unsafe_();
/* 382 */     StringBuilder _sb_ = new StringBuilder();
/* 383 */     _sb_.append("(");
/* 384 */     _sb_.append(this.level);
/* 385 */     _sb_.append(",");
/* 386 */     _sb_.append(this.levelupendtime);
/* 387 */     _sb_.append(",");
/* 388 */     _sb_.append(this.yaocaimap);
/* 389 */     _sb_.append(",");
/* 390 */     _sb_.append(this.mifang);
/* 391 */     _sb_.append(")");
/* 392 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 398 */     ListenableBean lb = new ListenableBean();
/* 399 */     lb.add(new xdb.logs.ListenableChanged().setVarName("level"));
/* 400 */     lb.add(new xdb.logs.ListenableChanged().setVarName("levelupendtime"));
/* 401 */     lb.add(new xdb.logs.ListenableMap().setVarName("yaocaimap"));
/* 402 */     lb.add(new xdb.logs.ListenableChanged().setVarName("mifang"));
/* 403 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.YaoDian {
/*     */     private Const() {}
/*     */     
/*     */     YaoDian nThis() {
/* 410 */       return YaoDian.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 416 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.YaoDian copy()
/*     */     {
/* 422 */       return YaoDian.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.YaoDian toData()
/*     */     {
/* 428 */       return YaoDian.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.YaoDian toBean()
/*     */     {
/* 433 */       return YaoDian.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.YaoDian toDataIf()
/*     */     {
/* 439 */       return YaoDian.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.YaoDian toBeanIf()
/*     */     {
/* 444 */       return YaoDian.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLevel()
/*     */     {
/* 451 */       YaoDian.this._xdb_verify_unsafe_();
/* 452 */       return YaoDian.this.level;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLevelupendtime()
/*     */     {
/* 459 */       YaoDian.this._xdb_verify_unsafe_();
/* 460 */       return YaoDian.this.levelupendtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getYaocaimap()
/*     */     {
/* 467 */       YaoDian.this._xdb_verify_unsafe_();
/* 468 */       return xdb.Consts.constMap(YaoDian.this.yaocaimap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getYaocaimapAsData()
/*     */     {
/* 475 */       YaoDian.this._xdb_verify_unsafe_();
/*     */       
/* 477 */       YaoDian _o_ = YaoDian.this;
/* 478 */       Map<Integer, Integer> yaocaimap = new HashMap();
/* 479 */       for (Map.Entry<Integer, Integer> _e_ : _o_.yaocaimap.entrySet())
/* 480 */         yaocaimap.put(_e_.getKey(), _e_.getValue());
/* 481 */       return yaocaimap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.MiFang getMifang()
/*     */     {
/* 488 */       YaoDian.this._xdb_verify_unsafe_();
/* 489 */       return (xbean.MiFang)xdb.Consts.toConst(YaoDian.this.mifang);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLevel(int _v_)
/*     */     {
/* 496 */       YaoDian.this._xdb_verify_unsafe_();
/* 497 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLevelupendtime(long _v_)
/*     */     {
/* 504 */       YaoDian.this._xdb_verify_unsafe_();
/* 505 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 511 */       YaoDian.this._xdb_verify_unsafe_();
/* 512 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 518 */       YaoDian.this._xdb_verify_unsafe_();
/* 519 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 525 */       return YaoDian.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 531 */       return YaoDian.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 537 */       YaoDian.this._xdb_verify_unsafe_();
/* 538 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 544 */       return YaoDian.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 550 */       return YaoDian.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 556 */       YaoDian.this._xdb_verify_unsafe_();
/* 557 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 563 */       return YaoDian.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 569 */       return YaoDian.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 575 */       return YaoDian.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 581 */       return YaoDian.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 587 */       return YaoDian.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 593 */       return YaoDian.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 599 */       return YaoDian.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.YaoDian
/*     */   {
/*     */     private int level;
/*     */     
/*     */     private long levelupendtime;
/*     */     
/*     */     private HashMap<Integer, Integer> yaocaimap;
/*     */     
/*     */     private xbean.MiFang mifang;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 617 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 622 */       this.yaocaimap = new HashMap();
/* 623 */       this.mifang = new MiFang.Data();
/*     */     }
/*     */     
/*     */     Data(xbean.YaoDian _o1_)
/*     */     {
/* 628 */       if ((_o1_ instanceof YaoDian)) { assign((YaoDian)_o1_);
/* 629 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 630 */       } else if ((_o1_ instanceof YaoDian.Const)) assign(((YaoDian.Const)_o1_).nThis()); else {
/* 631 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(YaoDian _o_) {
/* 636 */       this.level = _o_.level;
/* 637 */       this.levelupendtime = _o_.levelupendtime;
/* 638 */       this.yaocaimap = new HashMap();
/* 639 */       for (Map.Entry<Integer, Integer> _e_ : _o_.yaocaimap.entrySet())
/* 640 */         this.yaocaimap.put(_e_.getKey(), _e_.getValue());
/* 641 */       this.mifang = new MiFang.Data(_o_.mifang);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 646 */       this.level = _o_.level;
/* 647 */       this.levelupendtime = _o_.levelupendtime;
/* 648 */       this.yaocaimap = new HashMap();
/* 649 */       for (Map.Entry<Integer, Integer> _e_ : _o_.yaocaimap.entrySet())
/* 650 */         this.yaocaimap.put(_e_.getKey(), _e_.getValue());
/* 651 */       this.mifang = new MiFang.Data(_o_.mifang);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 657 */       _os_.marshal(this.level);
/* 658 */       _os_.marshal(this.levelupendtime);
/* 659 */       _os_.compact_uint32(this.yaocaimap.size());
/* 660 */       for (Map.Entry<Integer, Integer> _e_ : this.yaocaimap.entrySet())
/*     */       {
/* 662 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 663 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 665 */       this.mifang.marshal(_os_);
/* 666 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 672 */       this.level = _os_.unmarshal_int();
/* 673 */       this.levelupendtime = _os_.unmarshal_long();
/*     */       
/* 675 */       int size = _os_.uncompact_uint32();
/* 676 */       if (size >= 12)
/*     */       {
/* 678 */         this.yaocaimap = new HashMap(size * 2);
/*     */       }
/* 680 */       for (; size > 0; size--)
/*     */       {
/* 682 */         int _k_ = 0;
/* 683 */         _k_ = _os_.unmarshal_int();
/* 684 */         int _v_ = 0;
/* 685 */         _v_ = _os_.unmarshal_int();
/* 686 */         this.yaocaimap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 689 */       this.mifang.unmarshal(_os_);
/* 690 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 696 */       int _size_ = 0;
/* 697 */       _size_ += CodedOutputStream.computeInt32Size(1, this.level);
/* 698 */       _size_ += CodedOutputStream.computeInt64Size(2, this.levelupendtime);
/* 699 */       for (Map.Entry<Integer, Integer> _e_ : this.yaocaimap.entrySet())
/*     */       {
/* 701 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 702 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 704 */       _size_ += CodedOutputStream.computeMessageSize(4, this.mifang);
/* 705 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 713 */         _output_.writeInt32(1, this.level);
/* 714 */         _output_.writeInt64(2, this.levelupendtime);
/* 715 */         for (Map.Entry<Integer, Integer> _e_ : this.yaocaimap.entrySet())
/*     */         {
/* 717 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 718 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*     */         }
/* 720 */         _output_.writeMessage(4, this.mifang);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 724 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 726 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 734 */         boolean done = false;
/* 735 */         while (!done)
/*     */         {
/* 737 */           int tag = _input_.readTag();
/* 738 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 742 */             done = true;
/* 743 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 747 */             this.level = _input_.readInt32();
/* 748 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 752 */             this.levelupendtime = _input_.readInt64();
/* 753 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 757 */             int _k_ = 0;
/* 758 */             _k_ = _input_.readInt32();
/* 759 */             int readTag = _input_.readTag();
/* 760 */             if (24 != readTag)
/*     */             {
/* 762 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 764 */             int _v_ = 0;
/* 765 */             _v_ = _input_.readInt32();
/* 766 */             this.yaocaimap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 767 */             break;
/*     */           
/*     */ 
/*     */           case 34: 
/* 771 */             _input_.readMessage(this.mifang);
/* 772 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 776 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 778 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 787 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 791 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 793 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.YaoDian copy()
/*     */     {
/* 799 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.YaoDian toData()
/*     */     {
/* 805 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.YaoDian toBean()
/*     */     {
/* 810 */       return new YaoDian(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.YaoDian toDataIf()
/*     */     {
/* 816 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.YaoDian toBeanIf()
/*     */     {
/* 821 */       return new YaoDian(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 827 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 831 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 835 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 839 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 843 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 847 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 851 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLevel()
/*     */     {
/* 858 */       return this.level;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLevelupendtime()
/*     */     {
/* 865 */       return this.levelupendtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getYaocaimap()
/*     */     {
/* 872 */       return this.yaocaimap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getYaocaimapAsData()
/*     */     {
/* 879 */       return this.yaocaimap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.MiFang getMifang()
/*     */     {
/* 886 */       return this.mifang;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLevel(int _v_)
/*     */     {
/* 893 */       this.level = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLevelupendtime(long _v_)
/*     */     {
/* 900 */       this.levelupendtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 906 */       if (!(_o1_ instanceof Data)) return false;
/* 907 */       Data _o_ = (Data)_o1_;
/* 908 */       if (this.level != _o_.level) return false;
/* 909 */       if (this.levelupendtime != _o_.levelupendtime) return false;
/* 910 */       if (!this.yaocaimap.equals(_o_.yaocaimap)) return false;
/* 911 */       if (!this.mifang.equals(_o_.mifang)) return false;
/* 912 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 918 */       int _h_ = 0;
/* 919 */       _h_ += this.level;
/* 920 */       _h_ = (int)(_h_ + this.levelupendtime);
/* 921 */       _h_ += this.yaocaimap.hashCode();
/* 922 */       _h_ += this.mifang.hashCode();
/* 923 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 929 */       StringBuilder _sb_ = new StringBuilder();
/* 930 */       _sb_.append("(");
/* 931 */       _sb_.append(this.level);
/* 932 */       _sb_.append(",");
/* 933 */       _sb_.append(this.levelupendtime);
/* 934 */       _sb_.append(",");
/* 935 */       _sb_.append(this.yaocaimap);
/* 936 */       _sb_.append(",");
/* 937 */       _sb_.append(this.mifang);
/* 938 */       _sb_.append(")");
/* 939 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\YaoDian.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */