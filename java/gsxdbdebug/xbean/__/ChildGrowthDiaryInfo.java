/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class ChildGrowthDiaryInfo extends XBean implements xbean.ChildGrowthDiaryInfo
/*      */ {
/*      */   private long give_birth_time;
/*      */   private long childhood_begin_time;
/*      */   private long adult_begin_time;
/*      */   private ArrayList<xbean.ChildGrowthInfo> growth_info_list;
/*      */   private long another_give_birth_parent_role_id;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.give_birth_time = 0L;
/*   27 */     this.childhood_begin_time = 0L;
/*   28 */     this.adult_begin_time = 0L;
/*   29 */     this.growth_info_list.clear();
/*   30 */     this.another_give_birth_parent_role_id = -1L;
/*      */   }
/*      */   
/*      */   ChildGrowthDiaryInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.growth_info_list = new ArrayList();
/*   37 */     this.another_give_birth_parent_role_id = -1L;
/*      */   }
/*      */   
/*      */   public ChildGrowthDiaryInfo()
/*      */   {
/*   42 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public ChildGrowthDiaryInfo(ChildGrowthDiaryInfo _o_)
/*      */   {
/*   47 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   ChildGrowthDiaryInfo(xbean.ChildGrowthDiaryInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   52 */     super(_xp_, _vn_);
/*   53 */     if ((_o1_ instanceof ChildGrowthDiaryInfo)) { assign((ChildGrowthDiaryInfo)_o1_);
/*   54 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   55 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   56 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(ChildGrowthDiaryInfo _o_) {
/*   61 */     _o_._xdb_verify_unsafe_();
/*   62 */     this.give_birth_time = _o_.give_birth_time;
/*   63 */     this.childhood_begin_time = _o_.childhood_begin_time;
/*   64 */     this.adult_begin_time = _o_.adult_begin_time;
/*   65 */     this.growth_info_list = new ArrayList();
/*   66 */     for (xbean.ChildGrowthInfo _v_ : _o_.growth_info_list)
/*   67 */       this.growth_info_list.add(new ChildGrowthInfo(_v_, this, "growth_info_list"));
/*   68 */     this.another_give_birth_parent_role_id = _o_.another_give_birth_parent_role_id;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   73 */     this.give_birth_time = _o_.give_birth_time;
/*   74 */     this.childhood_begin_time = _o_.childhood_begin_time;
/*   75 */     this.adult_begin_time = _o_.adult_begin_time;
/*   76 */     this.growth_info_list = new ArrayList();
/*   77 */     for (xbean.ChildGrowthInfo _v_ : _o_.growth_info_list)
/*   78 */       this.growth_info_list.add(new ChildGrowthInfo(_v_, this, "growth_info_list"));
/*   79 */     this.another_give_birth_parent_role_id = _o_.another_give_birth_parent_role_id;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   85 */     _xdb_verify_unsafe_();
/*   86 */     _os_.marshal(this.give_birth_time);
/*   87 */     _os_.marshal(this.childhood_begin_time);
/*   88 */     _os_.marshal(this.adult_begin_time);
/*   89 */     _os_.compact_uint32(this.growth_info_list.size());
/*   90 */     for (xbean.ChildGrowthInfo _v_ : this.growth_info_list)
/*      */     {
/*   92 */       _v_.marshal(_os_);
/*      */     }
/*   94 */     _os_.marshal(this.another_give_birth_parent_role_id);
/*   95 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  101 */     _xdb_verify_unsafe_();
/*  102 */     this.give_birth_time = _os_.unmarshal_long();
/*  103 */     this.childhood_begin_time = _os_.unmarshal_long();
/*  104 */     this.adult_begin_time = _os_.unmarshal_long();
/*  105 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  107 */       xbean.ChildGrowthInfo _v_ = new ChildGrowthInfo(0, this, "growth_info_list");
/*  108 */       _v_.unmarshal(_os_);
/*  109 */       this.growth_info_list.add(_v_);
/*      */     }
/*  111 */     this.another_give_birth_parent_role_id = _os_.unmarshal_long();
/*  112 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  118 */     _xdb_verify_unsafe_();
/*  119 */     int _size_ = 0;
/*  120 */     _size_ += CodedOutputStream.computeInt64Size(1, this.give_birth_time);
/*  121 */     _size_ += CodedOutputStream.computeInt64Size(2, this.childhood_begin_time);
/*  122 */     _size_ += CodedOutputStream.computeInt64Size(3, this.adult_begin_time);
/*  123 */     for (xbean.ChildGrowthInfo _v_ : this.growth_info_list)
/*      */     {
/*  125 */       _size_ += CodedOutputStream.computeMessageSize(4, _v_);
/*      */     }
/*  127 */     _size_ += CodedOutputStream.computeInt64Size(5, this.another_give_birth_parent_role_id);
/*  128 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  134 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  137 */       _output_.writeInt64(1, this.give_birth_time);
/*  138 */       _output_.writeInt64(2, this.childhood_begin_time);
/*  139 */       _output_.writeInt64(3, this.adult_begin_time);
/*  140 */       for (xbean.ChildGrowthInfo _v_ : this.growth_info_list)
/*      */       {
/*  142 */         _output_.writeMessage(4, _v_);
/*      */       }
/*  144 */       _output_.writeInt64(5, this.another_give_birth_parent_role_id);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  148 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  150 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  156 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  159 */       boolean done = false;
/*  160 */       while (!done)
/*      */       {
/*  162 */         int tag = _input_.readTag();
/*  163 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  167 */           done = true;
/*  168 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  172 */           this.give_birth_time = _input_.readInt64();
/*  173 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  177 */           this.childhood_begin_time = _input_.readInt64();
/*  178 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  182 */           this.adult_begin_time = _input_.readInt64();
/*  183 */           break;
/*      */         
/*      */ 
/*      */         case 34: 
/*  187 */           xbean.ChildGrowthInfo _v_ = new ChildGrowthInfo(0, this, "growth_info_list");
/*  188 */           _input_.readMessage(_v_);
/*  189 */           this.growth_info_list.add(_v_);
/*  190 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  194 */           this.another_give_birth_parent_role_id = _input_.readInt64();
/*  195 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  199 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  201 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  210 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  214 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  216 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ChildGrowthDiaryInfo copy()
/*      */   {
/*  222 */     _xdb_verify_unsafe_();
/*  223 */     return new ChildGrowthDiaryInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ChildGrowthDiaryInfo toData()
/*      */   {
/*  229 */     _xdb_verify_unsafe_();
/*  230 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ChildGrowthDiaryInfo toBean()
/*      */   {
/*  235 */     _xdb_verify_unsafe_();
/*  236 */     return new ChildGrowthDiaryInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ChildGrowthDiaryInfo toDataIf()
/*      */   {
/*  242 */     _xdb_verify_unsafe_();
/*  243 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ChildGrowthDiaryInfo toBeanIf()
/*      */   {
/*  248 */     _xdb_verify_unsafe_();
/*  249 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  255 */     _xdb_verify_unsafe_();
/*  256 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getGive_birth_time()
/*      */   {
/*  263 */     _xdb_verify_unsafe_();
/*  264 */     return this.give_birth_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getChildhood_begin_time()
/*      */   {
/*  271 */     _xdb_verify_unsafe_();
/*  272 */     return this.childhood_begin_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getAdult_begin_time()
/*      */   {
/*  279 */     _xdb_verify_unsafe_();
/*  280 */     return this.adult_begin_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.ChildGrowthInfo> getGrowth_info_list()
/*      */   {
/*  287 */     _xdb_verify_unsafe_();
/*  288 */     return xdb.Logs.logList(new LogKey(this, "growth_info_list"), this.growth_info_list);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.ChildGrowthInfo> getGrowth_info_listAsData()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*      */     
/*  296 */     ChildGrowthDiaryInfo _o_ = this;
/*  297 */     List<xbean.ChildGrowthInfo> growth_info_list = new ArrayList();
/*  298 */     for (xbean.ChildGrowthInfo _v_ : _o_.growth_info_list)
/*  299 */       growth_info_list.add(new ChildGrowthInfo.Data(_v_));
/*  300 */     return growth_info_list;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getAnother_give_birth_parent_role_id()
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*  308 */     return this.another_give_birth_parent_role_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGive_birth_time(long _v_)
/*      */   {
/*  315 */     _xdb_verify_unsafe_();
/*  316 */     xdb.Logs.logIf(new LogKey(this, "give_birth_time")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  320 */         new LogLong(this, ChildGrowthDiaryInfo.this.give_birth_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  324 */             ChildGrowthDiaryInfo.this.give_birth_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  328 */     });
/*  329 */     this.give_birth_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setChildhood_begin_time(long _v_)
/*      */   {
/*  336 */     _xdb_verify_unsafe_();
/*  337 */     xdb.Logs.logIf(new LogKey(this, "childhood_begin_time")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  341 */         new LogLong(this, ChildGrowthDiaryInfo.this.childhood_begin_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  345 */             ChildGrowthDiaryInfo.this.childhood_begin_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  349 */     });
/*  350 */     this.childhood_begin_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAdult_begin_time(long _v_)
/*      */   {
/*  357 */     _xdb_verify_unsafe_();
/*  358 */     xdb.Logs.logIf(new LogKey(this, "adult_begin_time")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  362 */         new LogLong(this, ChildGrowthDiaryInfo.this.adult_begin_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  366 */             ChildGrowthDiaryInfo.this.adult_begin_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  370 */     });
/*  371 */     this.adult_begin_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAnother_give_birth_parent_role_id(long _v_)
/*      */   {
/*  378 */     _xdb_verify_unsafe_();
/*  379 */     xdb.Logs.logIf(new LogKey(this, "another_give_birth_parent_role_id")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  383 */         new LogLong(this, ChildGrowthDiaryInfo.this.another_give_birth_parent_role_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  387 */             ChildGrowthDiaryInfo.this.another_give_birth_parent_role_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  391 */     });
/*  392 */     this.another_give_birth_parent_role_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  398 */     _xdb_verify_unsafe_();
/*  399 */     ChildGrowthDiaryInfo _o_ = null;
/*  400 */     if ((_o1_ instanceof ChildGrowthDiaryInfo)) { _o_ = (ChildGrowthDiaryInfo)_o1_;
/*  401 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  402 */       return false;
/*  403 */     if (this.give_birth_time != _o_.give_birth_time) return false;
/*  404 */     if (this.childhood_begin_time != _o_.childhood_begin_time) return false;
/*  405 */     if (this.adult_begin_time != _o_.adult_begin_time) return false;
/*  406 */     if (!this.growth_info_list.equals(_o_.growth_info_list)) return false;
/*  407 */     if (this.another_give_birth_parent_role_id != _o_.another_give_birth_parent_role_id) return false;
/*  408 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  414 */     _xdb_verify_unsafe_();
/*  415 */     int _h_ = 0;
/*  416 */     _h_ = (int)(_h_ + this.give_birth_time);
/*  417 */     _h_ = (int)(_h_ + this.childhood_begin_time);
/*  418 */     _h_ = (int)(_h_ + this.adult_begin_time);
/*  419 */     _h_ += this.growth_info_list.hashCode();
/*  420 */     _h_ = (int)(_h_ + this.another_give_birth_parent_role_id);
/*  421 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  427 */     _xdb_verify_unsafe_();
/*  428 */     StringBuilder _sb_ = new StringBuilder();
/*  429 */     _sb_.append("(");
/*  430 */     _sb_.append(this.give_birth_time);
/*  431 */     _sb_.append(",");
/*  432 */     _sb_.append(this.childhood_begin_time);
/*  433 */     _sb_.append(",");
/*  434 */     _sb_.append(this.adult_begin_time);
/*  435 */     _sb_.append(",");
/*  436 */     _sb_.append(this.growth_info_list);
/*  437 */     _sb_.append(",");
/*  438 */     _sb_.append(this.another_give_birth_parent_role_id);
/*  439 */     _sb_.append(")");
/*  440 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  446 */     ListenableBean lb = new ListenableBean();
/*  447 */     lb.add(new ListenableChanged().setVarName("give_birth_time"));
/*  448 */     lb.add(new ListenableChanged().setVarName("childhood_begin_time"));
/*  449 */     lb.add(new ListenableChanged().setVarName("adult_begin_time"));
/*  450 */     lb.add(new ListenableChanged().setVarName("growth_info_list"));
/*  451 */     lb.add(new ListenableChanged().setVarName("another_give_birth_parent_role_id"));
/*  452 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.ChildGrowthDiaryInfo {
/*      */     private Const() {}
/*      */     
/*      */     ChildGrowthDiaryInfo nThis() {
/*  459 */       return ChildGrowthDiaryInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  465 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChildGrowthDiaryInfo copy()
/*      */     {
/*  471 */       return ChildGrowthDiaryInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChildGrowthDiaryInfo toData()
/*      */     {
/*  477 */       return ChildGrowthDiaryInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.ChildGrowthDiaryInfo toBean()
/*      */     {
/*  482 */       return ChildGrowthDiaryInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChildGrowthDiaryInfo toDataIf()
/*      */     {
/*  488 */       return ChildGrowthDiaryInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.ChildGrowthDiaryInfo toBeanIf()
/*      */     {
/*  493 */       return ChildGrowthDiaryInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGive_birth_time()
/*      */     {
/*  500 */       ChildGrowthDiaryInfo.this._xdb_verify_unsafe_();
/*  501 */       return ChildGrowthDiaryInfo.this.give_birth_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getChildhood_begin_time()
/*      */     {
/*  508 */       ChildGrowthDiaryInfo.this._xdb_verify_unsafe_();
/*  509 */       return ChildGrowthDiaryInfo.this.childhood_begin_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAdult_begin_time()
/*      */     {
/*  516 */       ChildGrowthDiaryInfo.this._xdb_verify_unsafe_();
/*  517 */       return ChildGrowthDiaryInfo.this.adult_begin_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.ChildGrowthInfo> getGrowth_info_list()
/*      */     {
/*  524 */       ChildGrowthDiaryInfo.this._xdb_verify_unsafe_();
/*  525 */       return xdb.Consts.constList(ChildGrowthDiaryInfo.this.growth_info_list);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.ChildGrowthInfo> getGrowth_info_listAsData()
/*      */     {
/*  531 */       ChildGrowthDiaryInfo.this._xdb_verify_unsafe_();
/*      */       
/*  533 */       ChildGrowthDiaryInfo _o_ = ChildGrowthDiaryInfo.this;
/*  534 */       List<xbean.ChildGrowthInfo> growth_info_list = new ArrayList();
/*  535 */       for (xbean.ChildGrowthInfo _v_ : _o_.growth_info_list)
/*  536 */         growth_info_list.add(new ChildGrowthInfo.Data(_v_));
/*  537 */       return growth_info_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAnother_give_birth_parent_role_id()
/*      */     {
/*  544 */       ChildGrowthDiaryInfo.this._xdb_verify_unsafe_();
/*  545 */       return ChildGrowthDiaryInfo.this.another_give_birth_parent_role_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGive_birth_time(long _v_)
/*      */     {
/*  552 */       ChildGrowthDiaryInfo.this._xdb_verify_unsafe_();
/*  553 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChildhood_begin_time(long _v_)
/*      */     {
/*  560 */       ChildGrowthDiaryInfo.this._xdb_verify_unsafe_();
/*  561 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAdult_begin_time(long _v_)
/*      */     {
/*  568 */       ChildGrowthDiaryInfo.this._xdb_verify_unsafe_();
/*  569 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAnother_give_birth_parent_role_id(long _v_)
/*      */     {
/*  576 */       ChildGrowthDiaryInfo.this._xdb_verify_unsafe_();
/*  577 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  583 */       ChildGrowthDiaryInfo.this._xdb_verify_unsafe_();
/*  584 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  590 */       ChildGrowthDiaryInfo.this._xdb_verify_unsafe_();
/*  591 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  597 */       return ChildGrowthDiaryInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  603 */       return ChildGrowthDiaryInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  609 */       ChildGrowthDiaryInfo.this._xdb_verify_unsafe_();
/*  610 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  616 */       return ChildGrowthDiaryInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  622 */       return ChildGrowthDiaryInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  628 */       ChildGrowthDiaryInfo.this._xdb_verify_unsafe_();
/*  629 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  635 */       return ChildGrowthDiaryInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  641 */       return ChildGrowthDiaryInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  647 */       return ChildGrowthDiaryInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  653 */       return ChildGrowthDiaryInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  659 */       return ChildGrowthDiaryInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  665 */       return ChildGrowthDiaryInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  671 */       return ChildGrowthDiaryInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.ChildGrowthDiaryInfo
/*      */   {
/*      */     private long give_birth_time;
/*      */     
/*      */     private long childhood_begin_time;
/*      */     
/*      */     private long adult_begin_time;
/*      */     
/*      */     private ArrayList<xbean.ChildGrowthInfo> growth_info_list;
/*      */     
/*      */     private long another_give_birth_parent_role_id;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  691 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  696 */       this.growth_info_list = new ArrayList();
/*  697 */       this.another_give_birth_parent_role_id = -1L;
/*      */     }
/*      */     
/*      */     Data(xbean.ChildGrowthDiaryInfo _o1_)
/*      */     {
/*  702 */       if ((_o1_ instanceof ChildGrowthDiaryInfo)) { assign((ChildGrowthDiaryInfo)_o1_);
/*  703 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  704 */       } else if ((_o1_ instanceof ChildGrowthDiaryInfo.Const)) assign(((ChildGrowthDiaryInfo.Const)_o1_).nThis()); else {
/*  705 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(ChildGrowthDiaryInfo _o_) {
/*  710 */       this.give_birth_time = _o_.give_birth_time;
/*  711 */       this.childhood_begin_time = _o_.childhood_begin_time;
/*  712 */       this.adult_begin_time = _o_.adult_begin_time;
/*  713 */       this.growth_info_list = new ArrayList();
/*  714 */       for (xbean.ChildGrowthInfo _v_ : _o_.growth_info_list)
/*  715 */         this.growth_info_list.add(new ChildGrowthInfo.Data(_v_));
/*  716 */       this.another_give_birth_parent_role_id = _o_.another_give_birth_parent_role_id;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  721 */       this.give_birth_time = _o_.give_birth_time;
/*  722 */       this.childhood_begin_time = _o_.childhood_begin_time;
/*  723 */       this.adult_begin_time = _o_.adult_begin_time;
/*  724 */       this.growth_info_list = new ArrayList();
/*  725 */       for (xbean.ChildGrowthInfo _v_ : _o_.growth_info_list)
/*  726 */         this.growth_info_list.add(new ChildGrowthInfo.Data(_v_));
/*  727 */       this.another_give_birth_parent_role_id = _o_.another_give_birth_parent_role_id;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  733 */       _os_.marshal(this.give_birth_time);
/*  734 */       _os_.marshal(this.childhood_begin_time);
/*  735 */       _os_.marshal(this.adult_begin_time);
/*  736 */       _os_.compact_uint32(this.growth_info_list.size());
/*  737 */       for (xbean.ChildGrowthInfo _v_ : this.growth_info_list)
/*      */       {
/*  739 */         _v_.marshal(_os_);
/*      */       }
/*  741 */       _os_.marshal(this.another_give_birth_parent_role_id);
/*  742 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  748 */       this.give_birth_time = _os_.unmarshal_long();
/*  749 */       this.childhood_begin_time = _os_.unmarshal_long();
/*  750 */       this.adult_begin_time = _os_.unmarshal_long();
/*  751 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  753 */         xbean.ChildGrowthInfo _v_ = xbean.Pod.newChildGrowthInfoData();
/*  754 */         _v_.unmarshal(_os_);
/*  755 */         this.growth_info_list.add(_v_);
/*      */       }
/*  757 */       this.another_give_birth_parent_role_id = _os_.unmarshal_long();
/*  758 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  764 */       int _size_ = 0;
/*  765 */       _size_ += CodedOutputStream.computeInt64Size(1, this.give_birth_time);
/*  766 */       _size_ += CodedOutputStream.computeInt64Size(2, this.childhood_begin_time);
/*  767 */       _size_ += CodedOutputStream.computeInt64Size(3, this.adult_begin_time);
/*  768 */       for (xbean.ChildGrowthInfo _v_ : this.growth_info_list)
/*      */       {
/*  770 */         _size_ += CodedOutputStream.computeMessageSize(4, _v_);
/*      */       }
/*  772 */       _size_ += CodedOutputStream.computeInt64Size(5, this.another_give_birth_parent_role_id);
/*  773 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  781 */         _output_.writeInt64(1, this.give_birth_time);
/*  782 */         _output_.writeInt64(2, this.childhood_begin_time);
/*  783 */         _output_.writeInt64(3, this.adult_begin_time);
/*  784 */         for (xbean.ChildGrowthInfo _v_ : this.growth_info_list)
/*      */         {
/*  786 */           _output_.writeMessage(4, _v_);
/*      */         }
/*  788 */         _output_.writeInt64(5, this.another_give_birth_parent_role_id);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  792 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  794 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  802 */         boolean done = false;
/*  803 */         while (!done)
/*      */         {
/*  805 */           int tag = _input_.readTag();
/*  806 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  810 */             done = true;
/*  811 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  815 */             this.give_birth_time = _input_.readInt64();
/*  816 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  820 */             this.childhood_begin_time = _input_.readInt64();
/*  821 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  825 */             this.adult_begin_time = _input_.readInt64();
/*  826 */             break;
/*      */           
/*      */ 
/*      */           case 34: 
/*  830 */             xbean.ChildGrowthInfo _v_ = xbean.Pod.newChildGrowthInfoData();
/*  831 */             _input_.readMessage(_v_);
/*  832 */             this.growth_info_list.add(_v_);
/*  833 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  837 */             this.another_give_birth_parent_role_id = _input_.readInt64();
/*  838 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  842 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  844 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  853 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  857 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  859 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChildGrowthDiaryInfo copy()
/*      */     {
/*  865 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChildGrowthDiaryInfo toData()
/*      */     {
/*  871 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.ChildGrowthDiaryInfo toBean()
/*      */     {
/*  876 */       return new ChildGrowthDiaryInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChildGrowthDiaryInfo toDataIf()
/*      */     {
/*  882 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.ChildGrowthDiaryInfo toBeanIf()
/*      */     {
/*  887 */       return new ChildGrowthDiaryInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  893 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  897 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  901 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  905 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  909 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  913 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  917 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGive_birth_time()
/*      */     {
/*  924 */       return this.give_birth_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getChildhood_begin_time()
/*      */     {
/*  931 */       return this.childhood_begin_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAdult_begin_time()
/*      */     {
/*  938 */       return this.adult_begin_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.ChildGrowthInfo> getGrowth_info_list()
/*      */     {
/*  945 */       return this.growth_info_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.ChildGrowthInfo> getGrowth_info_listAsData()
/*      */     {
/*  952 */       return this.growth_info_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAnother_give_birth_parent_role_id()
/*      */     {
/*  959 */       return this.another_give_birth_parent_role_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGive_birth_time(long _v_)
/*      */     {
/*  966 */       this.give_birth_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChildhood_begin_time(long _v_)
/*      */     {
/*  973 */       this.childhood_begin_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAdult_begin_time(long _v_)
/*      */     {
/*  980 */       this.adult_begin_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAnother_give_birth_parent_role_id(long _v_)
/*      */     {
/*  987 */       this.another_give_birth_parent_role_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/*  993 */       if (!(_o1_ instanceof Data)) return false;
/*  994 */       Data _o_ = (Data)_o1_;
/*  995 */       if (this.give_birth_time != _o_.give_birth_time) return false;
/*  996 */       if (this.childhood_begin_time != _o_.childhood_begin_time) return false;
/*  997 */       if (this.adult_begin_time != _o_.adult_begin_time) return false;
/*  998 */       if (!this.growth_info_list.equals(_o_.growth_info_list)) return false;
/*  999 */       if (this.another_give_birth_parent_role_id != _o_.another_give_birth_parent_role_id) return false;
/* 1000 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1006 */       int _h_ = 0;
/* 1007 */       _h_ = (int)(_h_ + this.give_birth_time);
/* 1008 */       _h_ = (int)(_h_ + this.childhood_begin_time);
/* 1009 */       _h_ = (int)(_h_ + this.adult_begin_time);
/* 1010 */       _h_ += this.growth_info_list.hashCode();
/* 1011 */       _h_ = (int)(_h_ + this.another_give_birth_parent_role_id);
/* 1012 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1018 */       StringBuilder _sb_ = new StringBuilder();
/* 1019 */       _sb_.append("(");
/* 1020 */       _sb_.append(this.give_birth_time);
/* 1021 */       _sb_.append(",");
/* 1022 */       _sb_.append(this.childhood_begin_time);
/* 1023 */       _sb_.append(",");
/* 1024 */       _sb_.append(this.adult_begin_time);
/* 1025 */       _sb_.append(",");
/* 1026 */       _sb_.append(this.growth_info_list);
/* 1027 */       _sb_.append(",");
/* 1028 */       _sb_.append(this.another_give_birth_parent_role_id);
/* 1029 */       _sb_.append(")");
/* 1030 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ChildGrowthDiaryInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */