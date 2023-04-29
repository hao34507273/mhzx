/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class IndianaAwardInfo extends XBean implements xbean.IndianaAwardInfo
/*      */ {
/*      */   private int attend_role_num;
/*      */   private long attend_role_num_timestamp;
/*      */   private boolean got_award_number;
/*      */   private HashMap<Integer, xbean.IndianaAwardRoleInfo> award_number_infos;
/*      */   private SetX<Integer> need_broadcast_numbers;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.attend_role_num = 0;
/*   27 */     this.attend_role_num_timestamp = 0L;
/*   28 */     this.got_award_number = false;
/*   29 */     this.award_number_infos.clear();
/*   30 */     this.need_broadcast_numbers.clear();
/*      */   }
/*      */   
/*      */   IndianaAwardInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.attend_role_num = 0;
/*   37 */     this.attend_role_num_timestamp = 0L;
/*   38 */     this.got_award_number = false;
/*   39 */     this.award_number_infos = new HashMap();
/*   40 */     this.need_broadcast_numbers = new SetX();
/*      */   }
/*      */   
/*      */   public IndianaAwardInfo()
/*      */   {
/*   45 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public IndianaAwardInfo(IndianaAwardInfo _o_)
/*      */   {
/*   50 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   IndianaAwardInfo(xbean.IndianaAwardInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   55 */     super(_xp_, _vn_);
/*   56 */     if ((_o1_ instanceof IndianaAwardInfo)) { assign((IndianaAwardInfo)_o1_);
/*   57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   59 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(IndianaAwardInfo _o_) {
/*   64 */     _o_._xdb_verify_unsafe_();
/*   65 */     this.attend_role_num = _o_.attend_role_num;
/*   66 */     this.attend_role_num_timestamp = _o_.attend_role_num_timestamp;
/*   67 */     this.got_award_number = _o_.got_award_number;
/*   68 */     this.award_number_infos = new HashMap();
/*   69 */     for (Map.Entry<Integer, xbean.IndianaAwardRoleInfo> _e_ : _o_.award_number_infos.entrySet())
/*   70 */       this.award_number_infos.put(_e_.getKey(), new IndianaAwardRoleInfo((xbean.IndianaAwardRoleInfo)_e_.getValue(), this, "award_number_infos"));
/*   71 */     this.need_broadcast_numbers = new SetX();
/*   72 */     this.need_broadcast_numbers.addAll(_o_.need_broadcast_numbers);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   77 */     this.attend_role_num = _o_.attend_role_num;
/*   78 */     this.attend_role_num_timestamp = _o_.attend_role_num_timestamp;
/*   79 */     this.got_award_number = _o_.got_award_number;
/*   80 */     this.award_number_infos = new HashMap();
/*   81 */     for (Map.Entry<Integer, xbean.IndianaAwardRoleInfo> _e_ : _o_.award_number_infos.entrySet())
/*   82 */       this.award_number_infos.put(_e_.getKey(), new IndianaAwardRoleInfo((xbean.IndianaAwardRoleInfo)_e_.getValue(), this, "award_number_infos"));
/*   83 */     this.need_broadcast_numbers = new SetX();
/*   84 */     this.need_broadcast_numbers.addAll(_o_.need_broadcast_numbers);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   90 */     _xdb_verify_unsafe_();
/*   91 */     _os_.marshal(this.attend_role_num);
/*   92 */     _os_.marshal(this.attend_role_num_timestamp);
/*   93 */     _os_.marshal(this.got_award_number);
/*   94 */     _os_.compact_uint32(this.award_number_infos.size());
/*   95 */     for (Map.Entry<Integer, xbean.IndianaAwardRoleInfo> _e_ : this.award_number_infos.entrySet())
/*      */     {
/*   97 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*   98 */       ((xbean.IndianaAwardRoleInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  100 */     _os_.compact_uint32(this.need_broadcast_numbers.size());
/*  101 */     for (Integer _v_ : this.need_broadcast_numbers)
/*      */     {
/*  103 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  105 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  111 */     _xdb_verify_unsafe_();
/*  112 */     this.attend_role_num = _os_.unmarshal_int();
/*  113 */     this.attend_role_num_timestamp = _os_.unmarshal_long();
/*  114 */     this.got_award_number = _os_.unmarshal_boolean();
/*      */     
/*  116 */     int size = _os_.uncompact_uint32();
/*  117 */     if (size >= 12)
/*      */     {
/*  119 */       this.award_number_infos = new HashMap(size * 2);
/*      */     }
/*  121 */     for (; size > 0; size--)
/*      */     {
/*  123 */       int _k_ = 0;
/*  124 */       _k_ = _os_.unmarshal_int();
/*  125 */       xbean.IndianaAwardRoleInfo _v_ = new IndianaAwardRoleInfo(0, this, "award_number_infos");
/*  126 */       _v_.unmarshal(_os_);
/*  127 */       this.award_number_infos.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  130 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  132 */       int _v_ = 0;
/*  133 */       _v_ = _os_.unmarshal_int();
/*  134 */       this.need_broadcast_numbers.add(Integer.valueOf(_v_));
/*      */     }
/*  136 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  142 */     _xdb_verify_unsafe_();
/*  143 */     int _size_ = 0;
/*  144 */     _size_ += CodedOutputStream.computeInt32Size(1, this.attend_role_num);
/*  145 */     _size_ += CodedOutputStream.computeInt64Size(2, this.attend_role_num_timestamp);
/*  146 */     _size_ += CodedOutputStream.computeBoolSize(3, this.got_award_number);
/*  147 */     for (Map.Entry<Integer, xbean.IndianaAwardRoleInfo> _e_ : this.award_number_infos.entrySet())
/*      */     {
/*  149 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*  150 */       _size_ += CodedOutputStream.computeMessageSize(4, (ppbio.Message)_e_.getValue());
/*      */     }
/*  152 */     for (Integer _v_ : this.need_broadcast_numbers)
/*      */     {
/*  154 */       _size_ += CodedOutputStream.computeInt32Size(5, _v_.intValue());
/*      */     }
/*  156 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  162 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  165 */       _output_.writeInt32(1, this.attend_role_num);
/*  166 */       _output_.writeInt64(2, this.attend_role_num_timestamp);
/*  167 */       _output_.writeBool(3, this.got_award_number);
/*  168 */       for (Map.Entry<Integer, xbean.IndianaAwardRoleInfo> _e_ : this.award_number_infos.entrySet())
/*      */       {
/*  170 */         _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/*  171 */         _output_.writeMessage(4, (ppbio.Message)_e_.getValue());
/*      */       }
/*  173 */       for (Integer _v_ : this.need_broadcast_numbers)
/*      */       {
/*  175 */         _output_.writeInt32(5, _v_.intValue());
/*      */       }
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  180 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  182 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  188 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  191 */       boolean done = false;
/*  192 */       while (!done)
/*      */       {
/*  194 */         int tag = _input_.readTag();
/*  195 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  199 */           done = true;
/*  200 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  204 */           this.attend_role_num = _input_.readInt32();
/*  205 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  209 */           this.attend_role_num_timestamp = _input_.readInt64();
/*  210 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  214 */           this.got_award_number = _input_.readBool();
/*  215 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  219 */           int _k_ = 0;
/*  220 */           _k_ = _input_.readInt32();
/*  221 */           int readTag = _input_.readTag();
/*  222 */           if (34 != readTag)
/*      */           {
/*  224 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  226 */           xbean.IndianaAwardRoleInfo _v_ = new IndianaAwardRoleInfo(0, this, "award_number_infos");
/*  227 */           _input_.readMessage(_v_);
/*  228 */           this.award_number_infos.put(Integer.valueOf(_k_), _v_);
/*  229 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  233 */           int _v_ = 0;
/*  234 */           _v_ = _input_.readInt32();
/*  235 */           this.need_broadcast_numbers.add(Integer.valueOf(_v_));
/*  236 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  240 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  242 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  251 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  255 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  257 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.IndianaAwardInfo copy()
/*      */   {
/*  263 */     _xdb_verify_unsafe_();
/*  264 */     return new IndianaAwardInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.IndianaAwardInfo toData()
/*      */   {
/*  270 */     _xdb_verify_unsafe_();
/*  271 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.IndianaAwardInfo toBean()
/*      */   {
/*  276 */     _xdb_verify_unsafe_();
/*  277 */     return new IndianaAwardInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.IndianaAwardInfo toDataIf()
/*      */   {
/*  283 */     _xdb_verify_unsafe_();
/*  284 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.IndianaAwardInfo toBeanIf()
/*      */   {
/*  289 */     _xdb_verify_unsafe_();
/*  290 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  296 */     _xdb_verify_unsafe_();
/*  297 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAttend_role_num()
/*      */   {
/*  304 */     _xdb_verify_unsafe_();
/*  305 */     return this.attend_role_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getAttend_role_num_timestamp()
/*      */   {
/*  312 */     _xdb_verify_unsafe_();
/*  313 */     return this.attend_role_num_timestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getGot_award_number()
/*      */   {
/*  320 */     _xdb_verify_unsafe_();
/*  321 */     return this.got_award_number;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.IndianaAwardRoleInfo> getAward_number_infos()
/*      */   {
/*  328 */     _xdb_verify_unsafe_();
/*  329 */     return xdb.Logs.logMap(new LogKey(this, "award_number_infos"), this.award_number_infos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.IndianaAwardRoleInfo> getAward_number_infosAsData()
/*      */   {
/*  336 */     _xdb_verify_unsafe_();
/*      */     
/*  338 */     IndianaAwardInfo _o_ = this;
/*  339 */     Map<Integer, xbean.IndianaAwardRoleInfo> award_number_infos = new HashMap();
/*  340 */     for (Map.Entry<Integer, xbean.IndianaAwardRoleInfo> _e_ : _o_.award_number_infos.entrySet())
/*  341 */       award_number_infos.put(_e_.getKey(), new IndianaAwardRoleInfo.Data((xbean.IndianaAwardRoleInfo)_e_.getValue()));
/*  342 */     return award_number_infos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getNeed_broadcast_numbers()
/*      */   {
/*  349 */     _xdb_verify_unsafe_();
/*  350 */     return xdb.Logs.logSet(new LogKey(this, "need_broadcast_numbers"), this.need_broadcast_numbers);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getNeed_broadcast_numbersAsData()
/*      */   {
/*  356 */     _xdb_verify_unsafe_();
/*      */     
/*  358 */     IndianaAwardInfo _o_ = this;
/*  359 */     Set<Integer> need_broadcast_numbers = new SetX();
/*  360 */     need_broadcast_numbers.addAll(_o_.need_broadcast_numbers);
/*  361 */     return need_broadcast_numbers;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAttend_role_num(int _v_)
/*      */   {
/*  368 */     _xdb_verify_unsafe_();
/*  369 */     xdb.Logs.logIf(new LogKey(this, "attend_role_num")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  373 */         new xdb.logs.LogInt(this, IndianaAwardInfo.this.attend_role_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  377 */             IndianaAwardInfo.this.attend_role_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  381 */     });
/*  382 */     this.attend_role_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAttend_role_num_timestamp(long _v_)
/*      */   {
/*  389 */     _xdb_verify_unsafe_();
/*  390 */     xdb.Logs.logIf(new LogKey(this, "attend_role_num_timestamp")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  394 */         new xdb.logs.LogLong(this, IndianaAwardInfo.this.attend_role_num_timestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  398 */             IndianaAwardInfo.this.attend_role_num_timestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  402 */     });
/*  403 */     this.attend_role_num_timestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGot_award_number(boolean _v_)
/*      */   {
/*  410 */     _xdb_verify_unsafe_();
/*  411 */     xdb.Logs.logIf(new LogKey(this, "got_award_number")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  415 */         new xdb.logs.LogObject(this, Boolean.valueOf(IndianaAwardInfo.this.got_award_number))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  419 */             IndianaAwardInfo.this.got_award_number = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  423 */     });
/*  424 */     this.got_award_number = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  430 */     _xdb_verify_unsafe_();
/*  431 */     IndianaAwardInfo _o_ = null;
/*  432 */     if ((_o1_ instanceof IndianaAwardInfo)) { _o_ = (IndianaAwardInfo)_o1_;
/*  433 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  434 */       return false;
/*  435 */     if (this.attend_role_num != _o_.attend_role_num) return false;
/*  436 */     if (this.attend_role_num_timestamp != _o_.attend_role_num_timestamp) return false;
/*  437 */     if (this.got_award_number != _o_.got_award_number) return false;
/*  438 */     if (!this.award_number_infos.equals(_o_.award_number_infos)) return false;
/*  439 */     if (!this.need_broadcast_numbers.equals(_o_.need_broadcast_numbers)) return false;
/*  440 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  446 */     _xdb_verify_unsafe_();
/*  447 */     int _h_ = 0;
/*  448 */     _h_ += this.attend_role_num;
/*  449 */     _h_ = (int)(_h_ + this.attend_role_num_timestamp);
/*  450 */     _h_ += (this.got_award_number ? 1231 : 1237);
/*  451 */     _h_ += this.award_number_infos.hashCode();
/*  452 */     _h_ += this.need_broadcast_numbers.hashCode();
/*  453 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  459 */     _xdb_verify_unsafe_();
/*  460 */     StringBuilder _sb_ = new StringBuilder();
/*  461 */     _sb_.append("(");
/*  462 */     _sb_.append(this.attend_role_num);
/*  463 */     _sb_.append(",");
/*  464 */     _sb_.append(this.attend_role_num_timestamp);
/*  465 */     _sb_.append(",");
/*  466 */     _sb_.append(this.got_award_number);
/*  467 */     _sb_.append(",");
/*  468 */     _sb_.append(this.award_number_infos);
/*  469 */     _sb_.append(",");
/*  470 */     _sb_.append(this.need_broadcast_numbers);
/*  471 */     _sb_.append(")");
/*  472 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  478 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  479 */     lb.add(new xdb.logs.ListenableChanged().setVarName("attend_role_num"));
/*  480 */     lb.add(new xdb.logs.ListenableChanged().setVarName("attend_role_num_timestamp"));
/*  481 */     lb.add(new xdb.logs.ListenableChanged().setVarName("got_award_number"));
/*  482 */     lb.add(new xdb.logs.ListenableMap().setVarName("award_number_infos"));
/*  483 */     lb.add(new xdb.logs.ListenableSet().setVarName("need_broadcast_numbers"));
/*  484 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.IndianaAwardInfo {
/*      */     private Const() {}
/*      */     
/*      */     IndianaAwardInfo nThis() {
/*  491 */       return IndianaAwardInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  497 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.IndianaAwardInfo copy()
/*      */     {
/*  503 */       return IndianaAwardInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.IndianaAwardInfo toData()
/*      */     {
/*  509 */       return IndianaAwardInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.IndianaAwardInfo toBean()
/*      */     {
/*  514 */       return IndianaAwardInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.IndianaAwardInfo toDataIf()
/*      */     {
/*  520 */       return IndianaAwardInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.IndianaAwardInfo toBeanIf()
/*      */     {
/*  525 */       return IndianaAwardInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAttend_role_num()
/*      */     {
/*  532 */       IndianaAwardInfo.this._xdb_verify_unsafe_();
/*  533 */       return IndianaAwardInfo.this.attend_role_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAttend_role_num_timestamp()
/*      */     {
/*  540 */       IndianaAwardInfo.this._xdb_verify_unsafe_();
/*  541 */       return IndianaAwardInfo.this.attend_role_num_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getGot_award_number()
/*      */     {
/*  548 */       IndianaAwardInfo.this._xdb_verify_unsafe_();
/*  549 */       return IndianaAwardInfo.this.got_award_number;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.IndianaAwardRoleInfo> getAward_number_infos()
/*      */     {
/*  556 */       IndianaAwardInfo.this._xdb_verify_unsafe_();
/*  557 */       return xdb.Consts.constMap(IndianaAwardInfo.this.award_number_infos);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.IndianaAwardRoleInfo> getAward_number_infosAsData()
/*      */     {
/*  564 */       IndianaAwardInfo.this._xdb_verify_unsafe_();
/*      */       
/*  566 */       IndianaAwardInfo _o_ = IndianaAwardInfo.this;
/*  567 */       Map<Integer, xbean.IndianaAwardRoleInfo> award_number_infos = new HashMap();
/*  568 */       for (Map.Entry<Integer, xbean.IndianaAwardRoleInfo> _e_ : _o_.award_number_infos.entrySet())
/*  569 */         award_number_infos.put(_e_.getKey(), new IndianaAwardRoleInfo.Data((xbean.IndianaAwardRoleInfo)_e_.getValue()));
/*  570 */       return award_number_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getNeed_broadcast_numbers()
/*      */     {
/*  577 */       IndianaAwardInfo.this._xdb_verify_unsafe_();
/*  578 */       return xdb.Consts.constSet(IndianaAwardInfo.this.need_broadcast_numbers);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getNeed_broadcast_numbersAsData()
/*      */     {
/*  584 */       IndianaAwardInfo.this._xdb_verify_unsafe_();
/*      */       
/*  586 */       IndianaAwardInfo _o_ = IndianaAwardInfo.this;
/*  587 */       Set<Integer> need_broadcast_numbers = new SetX();
/*  588 */       need_broadcast_numbers.addAll(_o_.need_broadcast_numbers);
/*  589 */       return need_broadcast_numbers;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAttend_role_num(int _v_)
/*      */     {
/*  596 */       IndianaAwardInfo.this._xdb_verify_unsafe_();
/*  597 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAttend_role_num_timestamp(long _v_)
/*      */     {
/*  604 */       IndianaAwardInfo.this._xdb_verify_unsafe_();
/*  605 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGot_award_number(boolean _v_)
/*      */     {
/*  612 */       IndianaAwardInfo.this._xdb_verify_unsafe_();
/*  613 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  619 */       IndianaAwardInfo.this._xdb_verify_unsafe_();
/*  620 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  626 */       IndianaAwardInfo.this._xdb_verify_unsafe_();
/*  627 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  633 */       return IndianaAwardInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  639 */       return IndianaAwardInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  645 */       IndianaAwardInfo.this._xdb_verify_unsafe_();
/*  646 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  652 */       return IndianaAwardInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  658 */       return IndianaAwardInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  664 */       IndianaAwardInfo.this._xdb_verify_unsafe_();
/*  665 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  671 */       return IndianaAwardInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  677 */       return IndianaAwardInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  683 */       return IndianaAwardInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  689 */       return IndianaAwardInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  695 */       return IndianaAwardInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  701 */       return IndianaAwardInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  707 */       return IndianaAwardInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.IndianaAwardInfo
/*      */   {
/*      */     private int attend_role_num;
/*      */     
/*      */     private long attend_role_num_timestamp;
/*      */     
/*      */     private boolean got_award_number;
/*      */     
/*      */     private HashMap<Integer, xbean.IndianaAwardRoleInfo> award_number_infos;
/*      */     
/*      */     private HashSet<Integer> need_broadcast_numbers;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  727 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  732 */       this.attend_role_num = 0;
/*  733 */       this.attend_role_num_timestamp = 0L;
/*  734 */       this.got_award_number = false;
/*  735 */       this.award_number_infos = new HashMap();
/*  736 */       this.need_broadcast_numbers = new HashSet();
/*      */     }
/*      */     
/*      */     Data(xbean.IndianaAwardInfo _o1_)
/*      */     {
/*  741 */       if ((_o1_ instanceof IndianaAwardInfo)) { assign((IndianaAwardInfo)_o1_);
/*  742 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  743 */       } else if ((_o1_ instanceof IndianaAwardInfo.Const)) assign(((IndianaAwardInfo.Const)_o1_).nThis()); else {
/*  744 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(IndianaAwardInfo _o_) {
/*  749 */       this.attend_role_num = _o_.attend_role_num;
/*  750 */       this.attend_role_num_timestamp = _o_.attend_role_num_timestamp;
/*  751 */       this.got_award_number = _o_.got_award_number;
/*  752 */       this.award_number_infos = new HashMap();
/*  753 */       for (Map.Entry<Integer, xbean.IndianaAwardRoleInfo> _e_ : _o_.award_number_infos.entrySet())
/*  754 */         this.award_number_infos.put(_e_.getKey(), new IndianaAwardRoleInfo.Data((xbean.IndianaAwardRoleInfo)_e_.getValue()));
/*  755 */       this.need_broadcast_numbers = new HashSet();
/*  756 */       this.need_broadcast_numbers.addAll(_o_.need_broadcast_numbers);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  761 */       this.attend_role_num = _o_.attend_role_num;
/*  762 */       this.attend_role_num_timestamp = _o_.attend_role_num_timestamp;
/*  763 */       this.got_award_number = _o_.got_award_number;
/*  764 */       this.award_number_infos = new HashMap();
/*  765 */       for (Map.Entry<Integer, xbean.IndianaAwardRoleInfo> _e_ : _o_.award_number_infos.entrySet())
/*  766 */         this.award_number_infos.put(_e_.getKey(), new IndianaAwardRoleInfo.Data((xbean.IndianaAwardRoleInfo)_e_.getValue()));
/*  767 */       this.need_broadcast_numbers = new HashSet();
/*  768 */       this.need_broadcast_numbers.addAll(_o_.need_broadcast_numbers);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  774 */       _os_.marshal(this.attend_role_num);
/*  775 */       _os_.marshal(this.attend_role_num_timestamp);
/*  776 */       _os_.marshal(this.got_award_number);
/*  777 */       _os_.compact_uint32(this.award_number_infos.size());
/*  778 */       for (Map.Entry<Integer, xbean.IndianaAwardRoleInfo> _e_ : this.award_number_infos.entrySet())
/*      */       {
/*  780 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  781 */         ((xbean.IndianaAwardRoleInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/*  783 */       _os_.compact_uint32(this.need_broadcast_numbers.size());
/*  784 */       for (Integer _v_ : this.need_broadcast_numbers)
/*      */       {
/*  786 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  788 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  794 */       this.attend_role_num = _os_.unmarshal_int();
/*  795 */       this.attend_role_num_timestamp = _os_.unmarshal_long();
/*  796 */       this.got_award_number = _os_.unmarshal_boolean();
/*      */       
/*  798 */       int size = _os_.uncompact_uint32();
/*  799 */       if (size >= 12)
/*      */       {
/*  801 */         this.award_number_infos = new HashMap(size * 2);
/*      */       }
/*  803 */       for (; size > 0; size--)
/*      */       {
/*  805 */         int _k_ = 0;
/*  806 */         _k_ = _os_.unmarshal_int();
/*  807 */         xbean.IndianaAwardRoleInfo _v_ = xbean.Pod.newIndianaAwardRoleInfoData();
/*  808 */         _v_.unmarshal(_os_);
/*  809 */         this.award_number_infos.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  812 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  814 */         int _v_ = 0;
/*  815 */         _v_ = _os_.unmarshal_int();
/*  816 */         this.need_broadcast_numbers.add(Integer.valueOf(_v_));
/*      */       }
/*  818 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  824 */       int _size_ = 0;
/*  825 */       _size_ += CodedOutputStream.computeInt32Size(1, this.attend_role_num);
/*  826 */       _size_ += CodedOutputStream.computeInt64Size(2, this.attend_role_num_timestamp);
/*  827 */       _size_ += CodedOutputStream.computeBoolSize(3, this.got_award_number);
/*  828 */       for (Map.Entry<Integer, xbean.IndianaAwardRoleInfo> _e_ : this.award_number_infos.entrySet())
/*      */       {
/*  830 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*  831 */         _size_ += CodedOutputStream.computeMessageSize(4, (ppbio.Message)_e_.getValue());
/*      */       }
/*  833 */       for (Integer _v_ : this.need_broadcast_numbers)
/*      */       {
/*  835 */         _size_ += CodedOutputStream.computeInt32Size(5, _v_.intValue());
/*      */       }
/*  837 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  845 */         _output_.writeInt32(1, this.attend_role_num);
/*  846 */         _output_.writeInt64(2, this.attend_role_num_timestamp);
/*  847 */         _output_.writeBool(3, this.got_award_number);
/*  848 */         for (Map.Entry<Integer, xbean.IndianaAwardRoleInfo> _e_ : this.award_number_infos.entrySet())
/*      */         {
/*  850 */           _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/*  851 */           _output_.writeMessage(4, (ppbio.Message)_e_.getValue());
/*      */         }
/*  853 */         for (Integer _v_ : this.need_broadcast_numbers)
/*      */         {
/*  855 */           _output_.writeInt32(5, _v_.intValue());
/*      */         }
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/*  860 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  862 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  870 */         boolean done = false;
/*  871 */         while (!done)
/*      */         {
/*  873 */           int tag = _input_.readTag();
/*  874 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  878 */             done = true;
/*  879 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  883 */             this.attend_role_num = _input_.readInt32();
/*  884 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  888 */             this.attend_role_num_timestamp = _input_.readInt64();
/*  889 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  893 */             this.got_award_number = _input_.readBool();
/*  894 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  898 */             int _k_ = 0;
/*  899 */             _k_ = _input_.readInt32();
/*  900 */             int readTag = _input_.readTag();
/*  901 */             if (34 != readTag)
/*      */             {
/*  903 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  905 */             xbean.IndianaAwardRoleInfo _v_ = xbean.Pod.newIndianaAwardRoleInfoData();
/*  906 */             _input_.readMessage(_v_);
/*  907 */             this.award_number_infos.put(Integer.valueOf(_k_), _v_);
/*  908 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  912 */             int _v_ = 0;
/*  913 */             _v_ = _input_.readInt32();
/*  914 */             this.need_broadcast_numbers.add(Integer.valueOf(_v_));
/*  915 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  919 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  921 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  930 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/*  934 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  936 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.IndianaAwardInfo copy()
/*      */     {
/*  942 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.IndianaAwardInfo toData()
/*      */     {
/*  948 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.IndianaAwardInfo toBean()
/*      */     {
/*  953 */       return new IndianaAwardInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.IndianaAwardInfo toDataIf()
/*      */     {
/*  959 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.IndianaAwardInfo toBeanIf()
/*      */     {
/*  964 */       return new IndianaAwardInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  970 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  974 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  978 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  982 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  986 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  990 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  994 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAttend_role_num()
/*      */     {
/* 1001 */       return this.attend_role_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getAttend_role_num_timestamp()
/*      */     {
/* 1008 */       return this.attend_role_num_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getGot_award_number()
/*      */     {
/* 1015 */       return this.got_award_number;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.IndianaAwardRoleInfo> getAward_number_infos()
/*      */     {
/* 1022 */       return this.award_number_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.IndianaAwardRoleInfo> getAward_number_infosAsData()
/*      */     {
/* 1029 */       return this.award_number_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getNeed_broadcast_numbers()
/*      */     {
/* 1036 */       return this.need_broadcast_numbers;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getNeed_broadcast_numbersAsData()
/*      */     {
/* 1043 */       return this.need_broadcast_numbers;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAttend_role_num(int _v_)
/*      */     {
/* 1050 */       this.attend_role_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAttend_role_num_timestamp(long _v_)
/*      */     {
/* 1057 */       this.attend_role_num_timestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGot_award_number(boolean _v_)
/*      */     {
/* 1064 */       this.got_award_number = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1070 */       if (!(_o1_ instanceof Data)) return false;
/* 1071 */       Data _o_ = (Data)_o1_;
/* 1072 */       if (this.attend_role_num != _o_.attend_role_num) return false;
/* 1073 */       if (this.attend_role_num_timestamp != _o_.attend_role_num_timestamp) return false;
/* 1074 */       if (this.got_award_number != _o_.got_award_number) return false;
/* 1075 */       if (!this.award_number_infos.equals(_o_.award_number_infos)) return false;
/* 1076 */       if (!this.need_broadcast_numbers.equals(_o_.need_broadcast_numbers)) return false;
/* 1077 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1083 */       int _h_ = 0;
/* 1084 */       _h_ += this.attend_role_num;
/* 1085 */       _h_ = (int)(_h_ + this.attend_role_num_timestamp);
/* 1086 */       _h_ += (this.got_award_number ? 1231 : 1237);
/* 1087 */       _h_ += this.award_number_infos.hashCode();
/* 1088 */       _h_ += this.need_broadcast_numbers.hashCode();
/* 1089 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1095 */       StringBuilder _sb_ = new StringBuilder();
/* 1096 */       _sb_.append("(");
/* 1097 */       _sb_.append(this.attend_role_num);
/* 1098 */       _sb_.append(",");
/* 1099 */       _sb_.append(this.attend_role_num_timestamp);
/* 1100 */       _sb_.append(",");
/* 1101 */       _sb_.append(this.got_award_number);
/* 1102 */       _sb_.append(",");
/* 1103 */       _sb_.append(this.award_number_infos);
/* 1104 */       _sb_.append(",");
/* 1105 */       _sb_.append(this.need_broadcast_numbers);
/* 1106 */       _sb_.append(")");
/* 1107 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\IndianaAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */