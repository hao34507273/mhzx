/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class FoolsDayInfo extends XBean implements xbean.FoolsDayInfo
/*      */ {
/*      */   private int make_chest_num;
/*      */   private ArrayList<Integer> alternative_buff_cfg_ids;
/*      */   private int refresh_time;
/*      */   private int point;
/*      */   private ArrayList<Long> open_chest_maker_ids;
/*      */   private long open_chest_maker_ids_timestamp;
/*      */   private boolean has_get_title_award;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.make_chest_num = 0;
/*   31 */     this.alternative_buff_cfg_ids.clear();
/*   32 */     this.refresh_time = 0;
/*   33 */     this.point = 0;
/*   34 */     this.open_chest_maker_ids.clear();
/*   35 */     this.open_chest_maker_ids_timestamp = 0L;
/*   36 */     this.has_get_title_award = false;
/*      */   }
/*      */   
/*      */   FoolsDayInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.make_chest_num = 0;
/*   43 */     this.alternative_buff_cfg_ids = new ArrayList();
/*   44 */     this.refresh_time = 0;
/*   45 */     this.point = 0;
/*   46 */     this.open_chest_maker_ids = new ArrayList();
/*   47 */     this.has_get_title_award = false;
/*      */   }
/*      */   
/*      */   public FoolsDayInfo()
/*      */   {
/*   52 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public FoolsDayInfo(FoolsDayInfo _o_)
/*      */   {
/*   57 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   FoolsDayInfo(xbean.FoolsDayInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   62 */     super(_xp_, _vn_);
/*   63 */     if ((_o1_ instanceof FoolsDayInfo)) { assign((FoolsDayInfo)_o1_);
/*   64 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   65 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   66 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(FoolsDayInfo _o_) {
/*   71 */     _o_._xdb_verify_unsafe_();
/*   72 */     this.make_chest_num = _o_.make_chest_num;
/*   73 */     this.alternative_buff_cfg_ids = new ArrayList();
/*   74 */     this.alternative_buff_cfg_ids.addAll(_o_.alternative_buff_cfg_ids);
/*   75 */     this.refresh_time = _o_.refresh_time;
/*   76 */     this.point = _o_.point;
/*   77 */     this.open_chest_maker_ids = new ArrayList();
/*   78 */     this.open_chest_maker_ids.addAll(_o_.open_chest_maker_ids);
/*   79 */     this.open_chest_maker_ids_timestamp = _o_.open_chest_maker_ids_timestamp;
/*   80 */     this.has_get_title_award = _o_.has_get_title_award;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   85 */     this.make_chest_num = _o_.make_chest_num;
/*   86 */     this.alternative_buff_cfg_ids = new ArrayList();
/*   87 */     this.alternative_buff_cfg_ids.addAll(_o_.alternative_buff_cfg_ids);
/*   88 */     this.refresh_time = _o_.refresh_time;
/*   89 */     this.point = _o_.point;
/*   90 */     this.open_chest_maker_ids = new ArrayList();
/*   91 */     this.open_chest_maker_ids.addAll(_o_.open_chest_maker_ids);
/*   92 */     this.open_chest_maker_ids_timestamp = _o_.open_chest_maker_ids_timestamp;
/*   93 */     this.has_get_title_award = _o_.has_get_title_award;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   99 */     _xdb_verify_unsafe_();
/*  100 */     _os_.marshal(this.make_chest_num);
/*  101 */     _os_.compact_uint32(this.alternative_buff_cfg_ids.size());
/*  102 */     for (Integer _v_ : this.alternative_buff_cfg_ids)
/*      */     {
/*  104 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  106 */     _os_.marshal(this.refresh_time);
/*  107 */     _os_.marshal(this.point);
/*  108 */     _os_.compact_uint32(this.open_chest_maker_ids.size());
/*  109 */     for (Long _v_ : this.open_chest_maker_ids)
/*      */     {
/*  111 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  113 */     _os_.marshal(this.open_chest_maker_ids_timestamp);
/*  114 */     _os_.marshal(this.has_get_title_award);
/*  115 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  121 */     _xdb_verify_unsafe_();
/*  122 */     this.make_chest_num = _os_.unmarshal_int();
/*  123 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  125 */       int _v_ = 0;
/*  126 */       _v_ = _os_.unmarshal_int();
/*  127 */       this.alternative_buff_cfg_ids.add(Integer.valueOf(_v_));
/*      */     }
/*  129 */     this.refresh_time = _os_.unmarshal_int();
/*  130 */     this.point = _os_.unmarshal_int();
/*  131 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  133 */       long _v_ = 0L;
/*  134 */       _v_ = _os_.unmarshal_long();
/*  135 */       this.open_chest_maker_ids.add(Long.valueOf(_v_));
/*      */     }
/*  137 */     this.open_chest_maker_ids_timestamp = _os_.unmarshal_long();
/*  138 */     this.has_get_title_award = _os_.unmarshal_boolean();
/*  139 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  145 */     _xdb_verify_unsafe_();
/*  146 */     int _size_ = 0;
/*  147 */     _size_ += CodedOutputStream.computeInt32Size(1, this.make_chest_num);
/*  148 */     for (Integer _v_ : this.alternative_buff_cfg_ids)
/*      */     {
/*  150 */       _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*      */     }
/*  152 */     _size_ += CodedOutputStream.computeInt32Size(3, this.refresh_time);
/*  153 */     _size_ += CodedOutputStream.computeInt32Size(4, this.point);
/*  154 */     for (Long _v_ : this.open_chest_maker_ids)
/*      */     {
/*  156 */       _size_ += CodedOutputStream.computeInt64Size(5, _v_.longValue());
/*      */     }
/*  158 */     _size_ += CodedOutputStream.computeInt64Size(6, this.open_chest_maker_ids_timestamp);
/*  159 */     _size_ += CodedOutputStream.computeBoolSize(7, this.has_get_title_award);
/*  160 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  166 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  169 */       _output_.writeInt32(1, this.make_chest_num);
/*  170 */       for (Integer _v_ : this.alternative_buff_cfg_ids)
/*      */       {
/*  172 */         _output_.writeInt32(2, _v_.intValue());
/*      */       }
/*  174 */       _output_.writeInt32(3, this.refresh_time);
/*  175 */       _output_.writeInt32(4, this.point);
/*  176 */       for (Long _v_ : this.open_chest_maker_ids)
/*      */       {
/*  178 */         _output_.writeInt64(5, _v_.longValue());
/*      */       }
/*  180 */       _output_.writeInt64(6, this.open_chest_maker_ids_timestamp);
/*  181 */       _output_.writeBool(7, this.has_get_title_award);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  185 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  187 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  193 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  196 */       boolean done = false;
/*  197 */       while (!done)
/*      */       {
/*  199 */         int tag = _input_.readTag();
/*  200 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  204 */           done = true;
/*  205 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  209 */           this.make_chest_num = _input_.readInt32();
/*  210 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  214 */           int _v_ = 0;
/*  215 */           _v_ = _input_.readInt32();
/*  216 */           this.alternative_buff_cfg_ids.add(Integer.valueOf(_v_));
/*  217 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  221 */           this.refresh_time = _input_.readInt32();
/*  222 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  226 */           this.point = _input_.readInt32();
/*  227 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  231 */           long _v_ = 0L;
/*  232 */           _v_ = _input_.readInt64();
/*  233 */           this.open_chest_maker_ids.add(Long.valueOf(_v_));
/*  234 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  238 */           this.open_chest_maker_ids_timestamp = _input_.readInt64();
/*  239 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  243 */           this.has_get_title_award = _input_.readBool();
/*  244 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  248 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  250 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  259 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  263 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  265 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FoolsDayInfo copy()
/*      */   {
/*  271 */     _xdb_verify_unsafe_();
/*  272 */     return new FoolsDayInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FoolsDayInfo toData()
/*      */   {
/*  278 */     _xdb_verify_unsafe_();
/*  279 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FoolsDayInfo toBean()
/*      */   {
/*  284 */     _xdb_verify_unsafe_();
/*  285 */     return new FoolsDayInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FoolsDayInfo toDataIf()
/*      */   {
/*  291 */     _xdb_verify_unsafe_();
/*  292 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FoolsDayInfo toBeanIf()
/*      */   {
/*  297 */     _xdb_verify_unsafe_();
/*  298 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  304 */     _xdb_verify_unsafe_();
/*  305 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMake_chest_num()
/*      */   {
/*  312 */     _xdb_verify_unsafe_();
/*  313 */     return this.make_chest_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getAlternative_buff_cfg_ids()
/*      */   {
/*  320 */     _xdb_verify_unsafe_();
/*  321 */     return Logs.logList(new LogKey(this, "alternative_buff_cfg_ids"), this.alternative_buff_cfg_ids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getAlternative_buff_cfg_idsAsData()
/*      */   {
/*  327 */     _xdb_verify_unsafe_();
/*      */     
/*  329 */     FoolsDayInfo _o_ = this;
/*  330 */     List<Integer> alternative_buff_cfg_ids = new ArrayList();
/*  331 */     alternative_buff_cfg_ids.addAll(_o_.alternative_buff_cfg_ids);
/*  332 */     return alternative_buff_cfg_ids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRefresh_time()
/*      */   {
/*  339 */     _xdb_verify_unsafe_();
/*  340 */     return this.refresh_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPoint()
/*      */   {
/*  347 */     _xdb_verify_unsafe_();
/*  348 */     return this.point;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getOpen_chest_maker_ids()
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*  356 */     return Logs.logList(new LogKey(this, "open_chest_maker_ids"), this.open_chest_maker_ids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getOpen_chest_maker_idsAsData()
/*      */   {
/*  362 */     _xdb_verify_unsafe_();
/*      */     
/*  364 */     FoolsDayInfo _o_ = this;
/*  365 */     List<Long> open_chest_maker_ids = new ArrayList();
/*  366 */     open_chest_maker_ids.addAll(_o_.open_chest_maker_ids);
/*  367 */     return open_chest_maker_ids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getOpen_chest_maker_ids_timestamp()
/*      */   {
/*  374 */     _xdb_verify_unsafe_();
/*  375 */     return this.open_chest_maker_ids_timestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getHas_get_title_award()
/*      */   {
/*  382 */     _xdb_verify_unsafe_();
/*  383 */     return this.has_get_title_award;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMake_chest_num(int _v_)
/*      */   {
/*  390 */     _xdb_verify_unsafe_();
/*  391 */     Logs.logIf(new LogKey(this, "make_chest_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  395 */         new LogInt(this, FoolsDayInfo.this.make_chest_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  399 */             FoolsDayInfo.this.make_chest_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  403 */     });
/*  404 */     this.make_chest_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRefresh_time(int _v_)
/*      */   {
/*  411 */     _xdb_verify_unsafe_();
/*  412 */     Logs.logIf(new LogKey(this, "refresh_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  416 */         new LogInt(this, FoolsDayInfo.this.refresh_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  420 */             FoolsDayInfo.this.refresh_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  424 */     });
/*  425 */     this.refresh_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPoint(int _v_)
/*      */   {
/*  432 */     _xdb_verify_unsafe_();
/*  433 */     Logs.logIf(new LogKey(this, "point")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  437 */         new LogInt(this, FoolsDayInfo.this.point)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  441 */             FoolsDayInfo.this.point = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  445 */     });
/*  446 */     this.point = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOpen_chest_maker_ids_timestamp(long _v_)
/*      */   {
/*  453 */     _xdb_verify_unsafe_();
/*  454 */     Logs.logIf(new LogKey(this, "open_chest_maker_ids_timestamp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  458 */         new xdb.logs.LogLong(this, FoolsDayInfo.this.open_chest_maker_ids_timestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  462 */             FoolsDayInfo.this.open_chest_maker_ids_timestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  466 */     });
/*  467 */     this.open_chest_maker_ids_timestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHas_get_title_award(boolean _v_)
/*      */   {
/*  474 */     _xdb_verify_unsafe_();
/*  475 */     Logs.logIf(new LogKey(this, "has_get_title_award")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  479 */         new xdb.logs.LogObject(this, Boolean.valueOf(FoolsDayInfo.this.has_get_title_award))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  483 */             FoolsDayInfo.this.has_get_title_award = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  487 */     });
/*  488 */     this.has_get_title_award = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  494 */     _xdb_verify_unsafe_();
/*  495 */     FoolsDayInfo _o_ = null;
/*  496 */     if ((_o1_ instanceof FoolsDayInfo)) { _o_ = (FoolsDayInfo)_o1_;
/*  497 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  498 */       return false;
/*  499 */     if (this.make_chest_num != _o_.make_chest_num) return false;
/*  500 */     if (!this.alternative_buff_cfg_ids.equals(_o_.alternative_buff_cfg_ids)) return false;
/*  501 */     if (this.refresh_time != _o_.refresh_time) return false;
/*  502 */     if (this.point != _o_.point) return false;
/*  503 */     if (!this.open_chest_maker_ids.equals(_o_.open_chest_maker_ids)) return false;
/*  504 */     if (this.open_chest_maker_ids_timestamp != _o_.open_chest_maker_ids_timestamp) return false;
/*  505 */     if (this.has_get_title_award != _o_.has_get_title_award) return false;
/*  506 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  512 */     _xdb_verify_unsafe_();
/*  513 */     int _h_ = 0;
/*  514 */     _h_ += this.make_chest_num;
/*  515 */     _h_ += this.alternative_buff_cfg_ids.hashCode();
/*  516 */     _h_ += this.refresh_time;
/*  517 */     _h_ += this.point;
/*  518 */     _h_ += this.open_chest_maker_ids.hashCode();
/*  519 */     _h_ = (int)(_h_ + this.open_chest_maker_ids_timestamp);
/*  520 */     _h_ += (this.has_get_title_award ? 1231 : 1237);
/*  521 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  527 */     _xdb_verify_unsafe_();
/*  528 */     StringBuilder _sb_ = new StringBuilder();
/*  529 */     _sb_.append("(");
/*  530 */     _sb_.append(this.make_chest_num);
/*  531 */     _sb_.append(",");
/*  532 */     _sb_.append(this.alternative_buff_cfg_ids);
/*  533 */     _sb_.append(",");
/*  534 */     _sb_.append(this.refresh_time);
/*  535 */     _sb_.append(",");
/*  536 */     _sb_.append(this.point);
/*  537 */     _sb_.append(",");
/*  538 */     _sb_.append(this.open_chest_maker_ids);
/*  539 */     _sb_.append(",");
/*  540 */     _sb_.append(this.open_chest_maker_ids_timestamp);
/*  541 */     _sb_.append(",");
/*  542 */     _sb_.append(this.has_get_title_award);
/*  543 */     _sb_.append(")");
/*  544 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  550 */     ListenableBean lb = new ListenableBean();
/*  551 */     lb.add(new ListenableChanged().setVarName("make_chest_num"));
/*  552 */     lb.add(new ListenableChanged().setVarName("alternative_buff_cfg_ids"));
/*  553 */     lb.add(new ListenableChanged().setVarName("refresh_time"));
/*  554 */     lb.add(new ListenableChanged().setVarName("point"));
/*  555 */     lb.add(new ListenableChanged().setVarName("open_chest_maker_ids"));
/*  556 */     lb.add(new ListenableChanged().setVarName("open_chest_maker_ids_timestamp"));
/*  557 */     lb.add(new ListenableChanged().setVarName("has_get_title_award"));
/*  558 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.FoolsDayInfo {
/*      */     private Const() {}
/*      */     
/*      */     FoolsDayInfo nThis() {
/*  565 */       return FoolsDayInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  571 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FoolsDayInfo copy()
/*      */     {
/*  577 */       return FoolsDayInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FoolsDayInfo toData()
/*      */     {
/*  583 */       return FoolsDayInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.FoolsDayInfo toBean()
/*      */     {
/*  588 */       return FoolsDayInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FoolsDayInfo toDataIf()
/*      */     {
/*  594 */       return FoolsDayInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.FoolsDayInfo toBeanIf()
/*      */     {
/*  599 */       return FoolsDayInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMake_chest_num()
/*      */     {
/*  606 */       FoolsDayInfo.this._xdb_verify_unsafe_();
/*  607 */       return FoolsDayInfo.this.make_chest_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getAlternative_buff_cfg_ids()
/*      */     {
/*  614 */       FoolsDayInfo.this._xdb_verify_unsafe_();
/*  615 */       return xdb.Consts.constList(FoolsDayInfo.this.alternative_buff_cfg_ids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getAlternative_buff_cfg_idsAsData()
/*      */     {
/*  621 */       FoolsDayInfo.this._xdb_verify_unsafe_();
/*      */       
/*  623 */       FoolsDayInfo _o_ = FoolsDayInfo.this;
/*  624 */       List<Integer> alternative_buff_cfg_ids = new ArrayList();
/*  625 */       alternative_buff_cfg_ids.addAll(_o_.alternative_buff_cfg_ids);
/*  626 */       return alternative_buff_cfg_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRefresh_time()
/*      */     {
/*  633 */       FoolsDayInfo.this._xdb_verify_unsafe_();
/*  634 */       return FoolsDayInfo.this.refresh_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPoint()
/*      */     {
/*  641 */       FoolsDayInfo.this._xdb_verify_unsafe_();
/*  642 */       return FoolsDayInfo.this.point;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getOpen_chest_maker_ids()
/*      */     {
/*  649 */       FoolsDayInfo.this._xdb_verify_unsafe_();
/*  650 */       return xdb.Consts.constList(FoolsDayInfo.this.open_chest_maker_ids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getOpen_chest_maker_idsAsData()
/*      */     {
/*  656 */       FoolsDayInfo.this._xdb_verify_unsafe_();
/*      */       
/*  658 */       FoolsDayInfo _o_ = FoolsDayInfo.this;
/*  659 */       List<Long> open_chest_maker_ids = new ArrayList();
/*  660 */       open_chest_maker_ids.addAll(_o_.open_chest_maker_ids);
/*  661 */       return open_chest_maker_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getOpen_chest_maker_ids_timestamp()
/*      */     {
/*  668 */       FoolsDayInfo.this._xdb_verify_unsafe_();
/*  669 */       return FoolsDayInfo.this.open_chest_maker_ids_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getHas_get_title_award()
/*      */     {
/*  676 */       FoolsDayInfo.this._xdb_verify_unsafe_();
/*  677 */       return FoolsDayInfo.this.has_get_title_award;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMake_chest_num(int _v_)
/*      */     {
/*  684 */       FoolsDayInfo.this._xdb_verify_unsafe_();
/*  685 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRefresh_time(int _v_)
/*      */     {
/*  692 */       FoolsDayInfo.this._xdb_verify_unsafe_();
/*  693 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPoint(int _v_)
/*      */     {
/*  700 */       FoolsDayInfo.this._xdb_verify_unsafe_();
/*  701 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOpen_chest_maker_ids_timestamp(long _v_)
/*      */     {
/*  708 */       FoolsDayInfo.this._xdb_verify_unsafe_();
/*  709 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHas_get_title_award(boolean _v_)
/*      */     {
/*  716 */       FoolsDayInfo.this._xdb_verify_unsafe_();
/*  717 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  723 */       FoolsDayInfo.this._xdb_verify_unsafe_();
/*  724 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  730 */       FoolsDayInfo.this._xdb_verify_unsafe_();
/*  731 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  737 */       return FoolsDayInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  743 */       return FoolsDayInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  749 */       FoolsDayInfo.this._xdb_verify_unsafe_();
/*  750 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  756 */       return FoolsDayInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  762 */       return FoolsDayInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  768 */       FoolsDayInfo.this._xdb_verify_unsafe_();
/*  769 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  775 */       return FoolsDayInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  781 */       return FoolsDayInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  787 */       return FoolsDayInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  793 */       return FoolsDayInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  799 */       return FoolsDayInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  805 */       return FoolsDayInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  811 */       return FoolsDayInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.FoolsDayInfo
/*      */   {
/*      */     private int make_chest_num;
/*      */     
/*      */     private ArrayList<Integer> alternative_buff_cfg_ids;
/*      */     
/*      */     private int refresh_time;
/*      */     
/*      */     private int point;
/*      */     
/*      */     private ArrayList<Long> open_chest_maker_ids;
/*      */     
/*      */     private long open_chest_maker_ids_timestamp;
/*      */     
/*      */     private boolean has_get_title_award;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  835 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  840 */       this.make_chest_num = 0;
/*  841 */       this.alternative_buff_cfg_ids = new ArrayList();
/*  842 */       this.refresh_time = 0;
/*  843 */       this.point = 0;
/*  844 */       this.open_chest_maker_ids = new ArrayList();
/*  845 */       this.has_get_title_award = false;
/*      */     }
/*      */     
/*      */     Data(xbean.FoolsDayInfo _o1_)
/*      */     {
/*  850 */       if ((_o1_ instanceof FoolsDayInfo)) { assign((FoolsDayInfo)_o1_);
/*  851 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  852 */       } else if ((_o1_ instanceof FoolsDayInfo.Const)) assign(((FoolsDayInfo.Const)_o1_).nThis()); else {
/*  853 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(FoolsDayInfo _o_) {
/*  858 */       this.make_chest_num = _o_.make_chest_num;
/*  859 */       this.alternative_buff_cfg_ids = new ArrayList();
/*  860 */       this.alternative_buff_cfg_ids.addAll(_o_.alternative_buff_cfg_ids);
/*  861 */       this.refresh_time = _o_.refresh_time;
/*  862 */       this.point = _o_.point;
/*  863 */       this.open_chest_maker_ids = new ArrayList();
/*  864 */       this.open_chest_maker_ids.addAll(_o_.open_chest_maker_ids);
/*  865 */       this.open_chest_maker_ids_timestamp = _o_.open_chest_maker_ids_timestamp;
/*  866 */       this.has_get_title_award = _o_.has_get_title_award;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  871 */       this.make_chest_num = _o_.make_chest_num;
/*  872 */       this.alternative_buff_cfg_ids = new ArrayList();
/*  873 */       this.alternative_buff_cfg_ids.addAll(_o_.alternative_buff_cfg_ids);
/*  874 */       this.refresh_time = _o_.refresh_time;
/*  875 */       this.point = _o_.point;
/*  876 */       this.open_chest_maker_ids = new ArrayList();
/*  877 */       this.open_chest_maker_ids.addAll(_o_.open_chest_maker_ids);
/*  878 */       this.open_chest_maker_ids_timestamp = _o_.open_chest_maker_ids_timestamp;
/*  879 */       this.has_get_title_award = _o_.has_get_title_award;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  885 */       _os_.marshal(this.make_chest_num);
/*  886 */       _os_.compact_uint32(this.alternative_buff_cfg_ids.size());
/*  887 */       for (Integer _v_ : this.alternative_buff_cfg_ids)
/*      */       {
/*  889 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  891 */       _os_.marshal(this.refresh_time);
/*  892 */       _os_.marshal(this.point);
/*  893 */       _os_.compact_uint32(this.open_chest_maker_ids.size());
/*  894 */       for (Long _v_ : this.open_chest_maker_ids)
/*      */       {
/*  896 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  898 */       _os_.marshal(this.open_chest_maker_ids_timestamp);
/*  899 */       _os_.marshal(this.has_get_title_award);
/*  900 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  906 */       this.make_chest_num = _os_.unmarshal_int();
/*  907 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  909 */         int _v_ = 0;
/*  910 */         _v_ = _os_.unmarshal_int();
/*  911 */         this.alternative_buff_cfg_ids.add(Integer.valueOf(_v_));
/*      */       }
/*  913 */       this.refresh_time = _os_.unmarshal_int();
/*  914 */       this.point = _os_.unmarshal_int();
/*  915 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  917 */         long _v_ = 0L;
/*  918 */         _v_ = _os_.unmarshal_long();
/*  919 */         this.open_chest_maker_ids.add(Long.valueOf(_v_));
/*      */       }
/*  921 */       this.open_chest_maker_ids_timestamp = _os_.unmarshal_long();
/*  922 */       this.has_get_title_award = _os_.unmarshal_boolean();
/*  923 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  929 */       int _size_ = 0;
/*  930 */       _size_ += CodedOutputStream.computeInt32Size(1, this.make_chest_num);
/*  931 */       for (Integer _v_ : this.alternative_buff_cfg_ids)
/*      */       {
/*  933 */         _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*      */       }
/*  935 */       _size_ += CodedOutputStream.computeInt32Size(3, this.refresh_time);
/*  936 */       _size_ += CodedOutputStream.computeInt32Size(4, this.point);
/*  937 */       for (Long _v_ : this.open_chest_maker_ids)
/*      */       {
/*  939 */         _size_ += CodedOutputStream.computeInt64Size(5, _v_.longValue());
/*      */       }
/*  941 */       _size_ += CodedOutputStream.computeInt64Size(6, this.open_chest_maker_ids_timestamp);
/*  942 */       _size_ += CodedOutputStream.computeBoolSize(7, this.has_get_title_award);
/*  943 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  951 */         _output_.writeInt32(1, this.make_chest_num);
/*  952 */         for (Integer _v_ : this.alternative_buff_cfg_ids)
/*      */         {
/*  954 */           _output_.writeInt32(2, _v_.intValue());
/*      */         }
/*  956 */         _output_.writeInt32(3, this.refresh_time);
/*  957 */         _output_.writeInt32(4, this.point);
/*  958 */         for (Long _v_ : this.open_chest_maker_ids)
/*      */         {
/*  960 */           _output_.writeInt64(5, _v_.longValue());
/*      */         }
/*  962 */         _output_.writeInt64(6, this.open_chest_maker_ids_timestamp);
/*  963 */         _output_.writeBool(7, this.has_get_title_award);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  967 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  969 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  977 */         boolean done = false;
/*  978 */         while (!done)
/*      */         {
/*  980 */           int tag = _input_.readTag();
/*  981 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  985 */             done = true;
/*  986 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  990 */             this.make_chest_num = _input_.readInt32();
/*  991 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  995 */             int _v_ = 0;
/*  996 */             _v_ = _input_.readInt32();
/*  997 */             this.alternative_buff_cfg_ids.add(Integer.valueOf(_v_));
/*  998 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1002 */             this.refresh_time = _input_.readInt32();
/* 1003 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1007 */             this.point = _input_.readInt32();
/* 1008 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1012 */             long _v_ = 0L;
/* 1013 */             _v_ = _input_.readInt64();
/* 1014 */             this.open_chest_maker_ids.add(Long.valueOf(_v_));
/* 1015 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1019 */             this.open_chest_maker_ids_timestamp = _input_.readInt64();
/* 1020 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1024 */             this.has_get_title_award = _input_.readBool();
/* 1025 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1029 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1031 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1040 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1044 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1046 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FoolsDayInfo copy()
/*      */     {
/* 1052 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FoolsDayInfo toData()
/*      */     {
/* 1058 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.FoolsDayInfo toBean()
/*      */     {
/* 1063 */       return new FoolsDayInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FoolsDayInfo toDataIf()
/*      */     {
/* 1069 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.FoolsDayInfo toBeanIf()
/*      */     {
/* 1074 */       return new FoolsDayInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1080 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1084 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1088 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1092 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1096 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1100 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1104 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMake_chest_num()
/*      */     {
/* 1111 */       return this.make_chest_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getAlternative_buff_cfg_ids()
/*      */     {
/* 1118 */       return this.alternative_buff_cfg_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getAlternative_buff_cfg_idsAsData()
/*      */     {
/* 1125 */       return this.alternative_buff_cfg_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRefresh_time()
/*      */     {
/* 1132 */       return this.refresh_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPoint()
/*      */     {
/* 1139 */       return this.point;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getOpen_chest_maker_ids()
/*      */     {
/* 1146 */       return this.open_chest_maker_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getOpen_chest_maker_idsAsData()
/*      */     {
/* 1153 */       return this.open_chest_maker_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getOpen_chest_maker_ids_timestamp()
/*      */     {
/* 1160 */       return this.open_chest_maker_ids_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getHas_get_title_award()
/*      */     {
/* 1167 */       return this.has_get_title_award;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMake_chest_num(int _v_)
/*      */     {
/* 1174 */       this.make_chest_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRefresh_time(int _v_)
/*      */     {
/* 1181 */       this.refresh_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPoint(int _v_)
/*      */     {
/* 1188 */       this.point = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOpen_chest_maker_ids_timestamp(long _v_)
/*      */     {
/* 1195 */       this.open_chest_maker_ids_timestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHas_get_title_award(boolean _v_)
/*      */     {
/* 1202 */       this.has_get_title_award = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1208 */       if (!(_o1_ instanceof Data)) return false;
/* 1209 */       Data _o_ = (Data)_o1_;
/* 1210 */       if (this.make_chest_num != _o_.make_chest_num) return false;
/* 1211 */       if (!this.alternative_buff_cfg_ids.equals(_o_.alternative_buff_cfg_ids)) return false;
/* 1212 */       if (this.refresh_time != _o_.refresh_time) return false;
/* 1213 */       if (this.point != _o_.point) return false;
/* 1214 */       if (!this.open_chest_maker_ids.equals(_o_.open_chest_maker_ids)) return false;
/* 1215 */       if (this.open_chest_maker_ids_timestamp != _o_.open_chest_maker_ids_timestamp) return false;
/* 1216 */       if (this.has_get_title_award != _o_.has_get_title_award) return false;
/* 1217 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1223 */       int _h_ = 0;
/* 1224 */       _h_ += this.make_chest_num;
/* 1225 */       _h_ += this.alternative_buff_cfg_ids.hashCode();
/* 1226 */       _h_ += this.refresh_time;
/* 1227 */       _h_ += this.point;
/* 1228 */       _h_ += this.open_chest_maker_ids.hashCode();
/* 1229 */       _h_ = (int)(_h_ + this.open_chest_maker_ids_timestamp);
/* 1230 */       _h_ += (this.has_get_title_award ? 1231 : 1237);
/* 1231 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1237 */       StringBuilder _sb_ = new StringBuilder();
/* 1238 */       _sb_.append("(");
/* 1239 */       _sb_.append(this.make_chest_num);
/* 1240 */       _sb_.append(",");
/* 1241 */       _sb_.append(this.alternative_buff_cfg_ids);
/* 1242 */       _sb_.append(",");
/* 1243 */       _sb_.append(this.refresh_time);
/* 1244 */       _sb_.append(",");
/* 1245 */       _sb_.append(this.point);
/* 1246 */       _sb_.append(",");
/* 1247 */       _sb_.append(this.open_chest_maker_ids);
/* 1248 */       _sb_.append(",");
/* 1249 */       _sb_.append(this.open_chest_maker_ids_timestamp);
/* 1250 */       _sb_.append(",");
/* 1251 */       _sb_.append(this.has_get_title_award);
/* 1252 */       _sb_.append(")");
/* 1253 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FoolsDayInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */