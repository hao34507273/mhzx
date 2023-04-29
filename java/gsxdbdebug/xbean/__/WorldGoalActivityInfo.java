/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashSet;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class WorldGoalActivityInfo extends XBean implements xbean.WorldGoalActivityInfo
/*      */ {
/*      */   private SetX<Integer> award_section_ids;
/*      */   private int extra_award_num;
/*      */   private long extra_award_num_timestamp;
/*      */   private int commit_item_sum;
/*      */   private boolean has_try_send_commit_item_sum_award;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.award_section_ids.clear();
/*   27 */     this.extra_award_num = 0;
/*   28 */     this.extra_award_num_timestamp = 0L;
/*   29 */     this.commit_item_sum = 0;
/*   30 */     this.has_try_send_commit_item_sum_award = false;
/*      */   }
/*      */   
/*      */   WorldGoalActivityInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.award_section_ids = new SetX();
/*   37 */     this.extra_award_num = 0;
/*   38 */     this.extra_award_num_timestamp = 0L;
/*   39 */     this.commit_item_sum = 0;
/*   40 */     this.has_try_send_commit_item_sum_award = false;
/*      */   }
/*      */   
/*      */   public WorldGoalActivityInfo()
/*      */   {
/*   45 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public WorldGoalActivityInfo(WorldGoalActivityInfo _o_)
/*      */   {
/*   50 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   WorldGoalActivityInfo(xbean.WorldGoalActivityInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   55 */     super(_xp_, _vn_);
/*   56 */     if ((_o1_ instanceof WorldGoalActivityInfo)) { assign((WorldGoalActivityInfo)_o1_);
/*   57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   59 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(WorldGoalActivityInfo _o_) {
/*   64 */     _o_._xdb_verify_unsafe_();
/*   65 */     this.award_section_ids = new SetX();
/*   66 */     this.award_section_ids.addAll(_o_.award_section_ids);
/*   67 */     this.extra_award_num = _o_.extra_award_num;
/*   68 */     this.extra_award_num_timestamp = _o_.extra_award_num_timestamp;
/*   69 */     this.commit_item_sum = _o_.commit_item_sum;
/*   70 */     this.has_try_send_commit_item_sum_award = _o_.has_try_send_commit_item_sum_award;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   75 */     this.award_section_ids = new SetX();
/*   76 */     this.award_section_ids.addAll(_o_.award_section_ids);
/*   77 */     this.extra_award_num = _o_.extra_award_num;
/*   78 */     this.extra_award_num_timestamp = _o_.extra_award_num_timestamp;
/*   79 */     this.commit_item_sum = _o_.commit_item_sum;
/*   80 */     this.has_try_send_commit_item_sum_award = _o_.has_try_send_commit_item_sum_award;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   86 */     _xdb_verify_unsafe_();
/*   87 */     _os_.compact_uint32(this.award_section_ids.size());
/*   88 */     for (Integer _v_ : this.award_section_ids)
/*      */     {
/*   90 */       _os_.marshal(_v_.intValue());
/*      */     }
/*   92 */     _os_.marshal(this.extra_award_num);
/*   93 */     _os_.marshal(this.extra_award_num_timestamp);
/*   94 */     _os_.marshal(this.commit_item_sum);
/*   95 */     _os_.marshal(this.has_try_send_commit_item_sum_award);
/*   96 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  102 */     _xdb_verify_unsafe_();
/*  103 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  105 */       int _v_ = 0;
/*  106 */       _v_ = _os_.unmarshal_int();
/*  107 */       this.award_section_ids.add(Integer.valueOf(_v_));
/*      */     }
/*  109 */     this.extra_award_num = _os_.unmarshal_int();
/*  110 */     this.extra_award_num_timestamp = _os_.unmarshal_long();
/*  111 */     this.commit_item_sum = _os_.unmarshal_int();
/*  112 */     this.has_try_send_commit_item_sum_award = _os_.unmarshal_boolean();
/*  113 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  119 */     _xdb_verify_unsafe_();
/*  120 */     int _size_ = 0;
/*  121 */     for (Integer _v_ : this.award_section_ids)
/*      */     {
/*  123 */       _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*      */     }
/*  125 */     _size_ += CodedOutputStream.computeInt32Size(2, this.extra_award_num);
/*  126 */     _size_ += CodedOutputStream.computeInt64Size(3, this.extra_award_num_timestamp);
/*  127 */     _size_ += CodedOutputStream.computeInt32Size(4, this.commit_item_sum);
/*  128 */     _size_ += CodedOutputStream.computeBoolSize(5, this.has_try_send_commit_item_sum_award);
/*  129 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  135 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  138 */       for (Integer _v_ : this.award_section_ids)
/*      */       {
/*  140 */         _output_.writeInt32(1, _v_.intValue());
/*      */       }
/*  142 */       _output_.writeInt32(2, this.extra_award_num);
/*  143 */       _output_.writeInt64(3, this.extra_award_num_timestamp);
/*  144 */       _output_.writeInt32(4, this.commit_item_sum);
/*  145 */       _output_.writeBool(5, this.has_try_send_commit_item_sum_award);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  149 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  151 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  157 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  160 */       boolean done = false;
/*  161 */       while (!done)
/*      */       {
/*  163 */         int tag = _input_.readTag();
/*  164 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  168 */           done = true;
/*  169 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  173 */           int _v_ = 0;
/*  174 */           _v_ = _input_.readInt32();
/*  175 */           this.award_section_ids.add(Integer.valueOf(_v_));
/*  176 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  180 */           this.extra_award_num = _input_.readInt32();
/*  181 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  185 */           this.extra_award_num_timestamp = _input_.readInt64();
/*  186 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  190 */           this.commit_item_sum = _input_.readInt32();
/*  191 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  195 */           this.has_try_send_commit_item_sum_award = _input_.readBool();
/*  196 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  200 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  202 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  211 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  215 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  217 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.WorldGoalActivityInfo copy()
/*      */   {
/*  223 */     _xdb_verify_unsafe_();
/*  224 */     return new WorldGoalActivityInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.WorldGoalActivityInfo toData()
/*      */   {
/*  230 */     _xdb_verify_unsafe_();
/*  231 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.WorldGoalActivityInfo toBean()
/*      */   {
/*  236 */     _xdb_verify_unsafe_();
/*  237 */     return new WorldGoalActivityInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.WorldGoalActivityInfo toDataIf()
/*      */   {
/*  243 */     _xdb_verify_unsafe_();
/*  244 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.WorldGoalActivityInfo toBeanIf()
/*      */   {
/*  249 */     _xdb_verify_unsafe_();
/*  250 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  256 */     _xdb_verify_unsafe_();
/*  257 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getAward_section_ids()
/*      */   {
/*  264 */     _xdb_verify_unsafe_();
/*  265 */     return xdb.Logs.logSet(new LogKey(this, "award_section_ids"), this.award_section_ids);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getAward_section_idsAsData()
/*      */   {
/*  271 */     _xdb_verify_unsafe_();
/*      */     
/*  273 */     WorldGoalActivityInfo _o_ = this;
/*  274 */     Set<Integer> award_section_ids = new SetX();
/*  275 */     award_section_ids.addAll(_o_.award_section_ids);
/*  276 */     return award_section_ids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getExtra_award_num()
/*      */   {
/*  283 */     _xdb_verify_unsafe_();
/*  284 */     return this.extra_award_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getExtra_award_num_timestamp()
/*      */   {
/*  291 */     _xdb_verify_unsafe_();
/*  292 */     return this.extra_award_num_timestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCommit_item_sum()
/*      */   {
/*  299 */     _xdb_verify_unsafe_();
/*  300 */     return this.commit_item_sum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getHas_try_send_commit_item_sum_award()
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*  308 */     return this.has_try_send_commit_item_sum_award;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setExtra_award_num(int _v_)
/*      */   {
/*  315 */     _xdb_verify_unsafe_();
/*  316 */     xdb.Logs.logIf(new LogKey(this, "extra_award_num")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  320 */         new xdb.logs.LogInt(this, WorldGoalActivityInfo.this.extra_award_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  324 */             WorldGoalActivityInfo.this.extra_award_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  328 */     });
/*  329 */     this.extra_award_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setExtra_award_num_timestamp(long _v_)
/*      */   {
/*  336 */     _xdb_verify_unsafe_();
/*  337 */     xdb.Logs.logIf(new LogKey(this, "extra_award_num_timestamp")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  341 */         new xdb.logs.LogLong(this, WorldGoalActivityInfo.this.extra_award_num_timestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  345 */             WorldGoalActivityInfo.this.extra_award_num_timestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  349 */     });
/*  350 */     this.extra_award_num_timestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCommit_item_sum(int _v_)
/*      */   {
/*  357 */     _xdb_verify_unsafe_();
/*  358 */     xdb.Logs.logIf(new LogKey(this, "commit_item_sum")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  362 */         new xdb.logs.LogInt(this, WorldGoalActivityInfo.this.commit_item_sum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  366 */             WorldGoalActivityInfo.this.commit_item_sum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  370 */     });
/*  371 */     this.commit_item_sum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHas_try_send_commit_item_sum_award(boolean _v_)
/*      */   {
/*  378 */     _xdb_verify_unsafe_();
/*  379 */     xdb.Logs.logIf(new LogKey(this, "has_try_send_commit_item_sum_award")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  383 */         new xdb.logs.LogObject(this, Boolean.valueOf(WorldGoalActivityInfo.this.has_try_send_commit_item_sum_award))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  387 */             WorldGoalActivityInfo.this.has_try_send_commit_item_sum_award = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  391 */     });
/*  392 */     this.has_try_send_commit_item_sum_award = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  398 */     _xdb_verify_unsafe_();
/*  399 */     WorldGoalActivityInfo _o_ = null;
/*  400 */     if ((_o1_ instanceof WorldGoalActivityInfo)) { _o_ = (WorldGoalActivityInfo)_o1_;
/*  401 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  402 */       return false;
/*  403 */     if (!this.award_section_ids.equals(_o_.award_section_ids)) return false;
/*  404 */     if (this.extra_award_num != _o_.extra_award_num) return false;
/*  405 */     if (this.extra_award_num_timestamp != _o_.extra_award_num_timestamp) return false;
/*  406 */     if (this.commit_item_sum != _o_.commit_item_sum) return false;
/*  407 */     if (this.has_try_send_commit_item_sum_award != _o_.has_try_send_commit_item_sum_award) return false;
/*  408 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  414 */     _xdb_verify_unsafe_();
/*  415 */     int _h_ = 0;
/*  416 */     _h_ += this.award_section_ids.hashCode();
/*  417 */     _h_ += this.extra_award_num;
/*  418 */     _h_ = (int)(_h_ + this.extra_award_num_timestamp);
/*  419 */     _h_ += this.commit_item_sum;
/*  420 */     _h_ += (this.has_try_send_commit_item_sum_award ? 1231 : 1237);
/*  421 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  427 */     _xdb_verify_unsafe_();
/*  428 */     StringBuilder _sb_ = new StringBuilder();
/*  429 */     _sb_.append("(");
/*  430 */     _sb_.append(this.award_section_ids);
/*  431 */     _sb_.append(",");
/*  432 */     _sb_.append(this.extra_award_num);
/*  433 */     _sb_.append(",");
/*  434 */     _sb_.append(this.extra_award_num_timestamp);
/*  435 */     _sb_.append(",");
/*  436 */     _sb_.append(this.commit_item_sum);
/*  437 */     _sb_.append(",");
/*  438 */     _sb_.append(this.has_try_send_commit_item_sum_award);
/*  439 */     _sb_.append(")");
/*  440 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  446 */     ListenableBean lb = new ListenableBean();
/*  447 */     lb.add(new xdb.logs.ListenableSet().setVarName("award_section_ids"));
/*  448 */     lb.add(new ListenableChanged().setVarName("extra_award_num"));
/*  449 */     lb.add(new ListenableChanged().setVarName("extra_award_num_timestamp"));
/*  450 */     lb.add(new ListenableChanged().setVarName("commit_item_sum"));
/*  451 */     lb.add(new ListenableChanged().setVarName("has_try_send_commit_item_sum_award"));
/*  452 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.WorldGoalActivityInfo {
/*      */     private Const() {}
/*      */     
/*      */     WorldGoalActivityInfo nThis() {
/*  459 */       return WorldGoalActivityInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  465 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WorldGoalActivityInfo copy()
/*      */     {
/*  471 */       return WorldGoalActivityInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WorldGoalActivityInfo toData()
/*      */     {
/*  477 */       return WorldGoalActivityInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.WorldGoalActivityInfo toBean()
/*      */     {
/*  482 */       return WorldGoalActivityInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WorldGoalActivityInfo toDataIf()
/*      */     {
/*  488 */       return WorldGoalActivityInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.WorldGoalActivityInfo toBeanIf()
/*      */     {
/*  493 */       return WorldGoalActivityInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getAward_section_ids()
/*      */     {
/*  500 */       WorldGoalActivityInfo.this._xdb_verify_unsafe_();
/*  501 */       return xdb.Consts.constSet(WorldGoalActivityInfo.this.award_section_ids);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getAward_section_idsAsData()
/*      */     {
/*  507 */       WorldGoalActivityInfo.this._xdb_verify_unsafe_();
/*      */       
/*  509 */       WorldGoalActivityInfo _o_ = WorldGoalActivityInfo.this;
/*  510 */       Set<Integer> award_section_ids = new SetX();
/*  511 */       award_section_ids.addAll(_o_.award_section_ids);
/*  512 */       return award_section_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getExtra_award_num()
/*      */     {
/*  519 */       WorldGoalActivityInfo.this._xdb_verify_unsafe_();
/*  520 */       return WorldGoalActivityInfo.this.extra_award_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getExtra_award_num_timestamp()
/*      */     {
/*  527 */       WorldGoalActivityInfo.this._xdb_verify_unsafe_();
/*  528 */       return WorldGoalActivityInfo.this.extra_award_num_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCommit_item_sum()
/*      */     {
/*  535 */       WorldGoalActivityInfo.this._xdb_verify_unsafe_();
/*  536 */       return WorldGoalActivityInfo.this.commit_item_sum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getHas_try_send_commit_item_sum_award()
/*      */     {
/*  543 */       WorldGoalActivityInfo.this._xdb_verify_unsafe_();
/*  544 */       return WorldGoalActivityInfo.this.has_try_send_commit_item_sum_award;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExtra_award_num(int _v_)
/*      */     {
/*  551 */       WorldGoalActivityInfo.this._xdb_verify_unsafe_();
/*  552 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExtra_award_num_timestamp(long _v_)
/*      */     {
/*  559 */       WorldGoalActivityInfo.this._xdb_verify_unsafe_();
/*  560 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCommit_item_sum(int _v_)
/*      */     {
/*  567 */       WorldGoalActivityInfo.this._xdb_verify_unsafe_();
/*  568 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHas_try_send_commit_item_sum_award(boolean _v_)
/*      */     {
/*  575 */       WorldGoalActivityInfo.this._xdb_verify_unsafe_();
/*  576 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  582 */       WorldGoalActivityInfo.this._xdb_verify_unsafe_();
/*  583 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  589 */       WorldGoalActivityInfo.this._xdb_verify_unsafe_();
/*  590 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  596 */       return WorldGoalActivityInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  602 */       return WorldGoalActivityInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  608 */       WorldGoalActivityInfo.this._xdb_verify_unsafe_();
/*  609 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  615 */       return WorldGoalActivityInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  621 */       return WorldGoalActivityInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  627 */       WorldGoalActivityInfo.this._xdb_verify_unsafe_();
/*  628 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  634 */       return WorldGoalActivityInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  640 */       return WorldGoalActivityInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  646 */       return WorldGoalActivityInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  652 */       return WorldGoalActivityInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  658 */       return WorldGoalActivityInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  664 */       return WorldGoalActivityInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  670 */       return WorldGoalActivityInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.WorldGoalActivityInfo
/*      */   {
/*      */     private HashSet<Integer> award_section_ids;
/*      */     
/*      */     private int extra_award_num;
/*      */     
/*      */     private long extra_award_num_timestamp;
/*      */     
/*      */     private int commit_item_sum;
/*      */     
/*      */     private boolean has_try_send_commit_item_sum_award;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  690 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  695 */       this.award_section_ids = new HashSet();
/*  696 */       this.extra_award_num = 0;
/*  697 */       this.extra_award_num_timestamp = 0L;
/*  698 */       this.commit_item_sum = 0;
/*  699 */       this.has_try_send_commit_item_sum_award = false;
/*      */     }
/*      */     
/*      */     Data(xbean.WorldGoalActivityInfo _o1_)
/*      */     {
/*  704 */       if ((_o1_ instanceof WorldGoalActivityInfo)) { assign((WorldGoalActivityInfo)_o1_);
/*  705 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  706 */       } else if ((_o1_ instanceof WorldGoalActivityInfo.Const)) assign(((WorldGoalActivityInfo.Const)_o1_).nThis()); else {
/*  707 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(WorldGoalActivityInfo _o_) {
/*  712 */       this.award_section_ids = new HashSet();
/*  713 */       this.award_section_ids.addAll(_o_.award_section_ids);
/*  714 */       this.extra_award_num = _o_.extra_award_num;
/*  715 */       this.extra_award_num_timestamp = _o_.extra_award_num_timestamp;
/*  716 */       this.commit_item_sum = _o_.commit_item_sum;
/*  717 */       this.has_try_send_commit_item_sum_award = _o_.has_try_send_commit_item_sum_award;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  722 */       this.award_section_ids = new HashSet();
/*  723 */       this.award_section_ids.addAll(_o_.award_section_ids);
/*  724 */       this.extra_award_num = _o_.extra_award_num;
/*  725 */       this.extra_award_num_timestamp = _o_.extra_award_num_timestamp;
/*  726 */       this.commit_item_sum = _o_.commit_item_sum;
/*  727 */       this.has_try_send_commit_item_sum_award = _o_.has_try_send_commit_item_sum_award;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  733 */       _os_.compact_uint32(this.award_section_ids.size());
/*  734 */       for (Integer _v_ : this.award_section_ids)
/*      */       {
/*  736 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  738 */       _os_.marshal(this.extra_award_num);
/*  739 */       _os_.marshal(this.extra_award_num_timestamp);
/*  740 */       _os_.marshal(this.commit_item_sum);
/*  741 */       _os_.marshal(this.has_try_send_commit_item_sum_award);
/*  742 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  748 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  750 */         int _v_ = 0;
/*  751 */         _v_ = _os_.unmarshal_int();
/*  752 */         this.award_section_ids.add(Integer.valueOf(_v_));
/*      */       }
/*  754 */       this.extra_award_num = _os_.unmarshal_int();
/*  755 */       this.extra_award_num_timestamp = _os_.unmarshal_long();
/*  756 */       this.commit_item_sum = _os_.unmarshal_int();
/*  757 */       this.has_try_send_commit_item_sum_award = _os_.unmarshal_boolean();
/*  758 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  764 */       int _size_ = 0;
/*  765 */       for (Integer _v_ : this.award_section_ids)
/*      */       {
/*  767 */         _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*      */       }
/*  769 */       _size_ += CodedOutputStream.computeInt32Size(2, this.extra_award_num);
/*  770 */       _size_ += CodedOutputStream.computeInt64Size(3, this.extra_award_num_timestamp);
/*  771 */       _size_ += CodedOutputStream.computeInt32Size(4, this.commit_item_sum);
/*  772 */       _size_ += CodedOutputStream.computeBoolSize(5, this.has_try_send_commit_item_sum_award);
/*  773 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  781 */         for (Integer _v_ : this.award_section_ids)
/*      */         {
/*  783 */           _output_.writeInt32(1, _v_.intValue());
/*      */         }
/*  785 */         _output_.writeInt32(2, this.extra_award_num);
/*  786 */         _output_.writeInt64(3, this.extra_award_num_timestamp);
/*  787 */         _output_.writeInt32(4, this.commit_item_sum);
/*  788 */         _output_.writeBool(5, this.has_try_send_commit_item_sum_award);
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
/*  815 */             int _v_ = 0;
/*  816 */             _v_ = _input_.readInt32();
/*  817 */             this.award_section_ids.add(Integer.valueOf(_v_));
/*  818 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  822 */             this.extra_award_num = _input_.readInt32();
/*  823 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  827 */             this.extra_award_num_timestamp = _input_.readInt64();
/*  828 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  832 */             this.commit_item_sum = _input_.readInt32();
/*  833 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  837 */             this.has_try_send_commit_item_sum_award = _input_.readBool();
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
/*      */     public xbean.WorldGoalActivityInfo copy()
/*      */     {
/*  865 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WorldGoalActivityInfo toData()
/*      */     {
/*  871 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.WorldGoalActivityInfo toBean()
/*      */     {
/*  876 */       return new WorldGoalActivityInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WorldGoalActivityInfo toDataIf()
/*      */     {
/*  882 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.WorldGoalActivityInfo toBeanIf()
/*      */     {
/*  887 */       return new WorldGoalActivityInfo(this, null, null);
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
/*      */     public Set<Integer> getAward_section_ids()
/*      */     {
/*  924 */       return this.award_section_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getAward_section_idsAsData()
/*      */     {
/*  931 */       return this.award_section_ids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getExtra_award_num()
/*      */     {
/*  938 */       return this.extra_award_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getExtra_award_num_timestamp()
/*      */     {
/*  945 */       return this.extra_award_num_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCommit_item_sum()
/*      */     {
/*  952 */       return this.commit_item_sum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getHas_try_send_commit_item_sum_award()
/*      */     {
/*  959 */       return this.has_try_send_commit_item_sum_award;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExtra_award_num(int _v_)
/*      */     {
/*  966 */       this.extra_award_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExtra_award_num_timestamp(long _v_)
/*      */     {
/*  973 */       this.extra_award_num_timestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCommit_item_sum(int _v_)
/*      */     {
/*  980 */       this.commit_item_sum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHas_try_send_commit_item_sum_award(boolean _v_)
/*      */     {
/*  987 */       this.has_try_send_commit_item_sum_award = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/*  993 */       if (!(_o1_ instanceof Data)) return false;
/*  994 */       Data _o_ = (Data)_o1_;
/*  995 */       if (!this.award_section_ids.equals(_o_.award_section_ids)) return false;
/*  996 */       if (this.extra_award_num != _o_.extra_award_num) return false;
/*  997 */       if (this.extra_award_num_timestamp != _o_.extra_award_num_timestamp) return false;
/*  998 */       if (this.commit_item_sum != _o_.commit_item_sum) return false;
/*  999 */       if (this.has_try_send_commit_item_sum_award != _o_.has_try_send_commit_item_sum_award) return false;
/* 1000 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1006 */       int _h_ = 0;
/* 1007 */       _h_ += this.award_section_ids.hashCode();
/* 1008 */       _h_ += this.extra_award_num;
/* 1009 */       _h_ = (int)(_h_ + this.extra_award_num_timestamp);
/* 1010 */       _h_ += this.commit_item_sum;
/* 1011 */       _h_ += (this.has_try_send_commit_item_sum_award ? 1231 : 1237);
/* 1012 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1018 */       StringBuilder _sb_ = new StringBuilder();
/* 1019 */       _sb_.append("(");
/* 1020 */       _sb_.append(this.award_section_ids);
/* 1021 */       _sb_.append(",");
/* 1022 */       _sb_.append(this.extra_award_num);
/* 1023 */       _sb_.append(",");
/* 1024 */       _sb_.append(this.extra_award_num_timestamp);
/* 1025 */       _sb_.append(",");
/* 1026 */       _sb_.append(this.commit_item_sum);
/* 1027 */       _sb_.append(",");
/* 1028 */       _sb_.append(this.has_try_send_commit_item_sum_award);
/* 1029 */       _sb_.append(")");
/* 1030 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\WorldGoalActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */