/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class MergeCompensationInfo extends XBean implements xbean.MergeCompensationInfo
/*      */ {
/*      */   private HashMap<Long, xbean.ServerLevelInfo> server_level_infos;
/*      */   private long max_server_level_zoneid;
/*      */   private long merge_system_timestamp;
/*      */   private long merge_time_offset;
/*      */   private boolean is_data_available;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.server_level_infos.clear();
/*   27 */     this.max_server_level_zoneid = 0L;
/*   28 */     this.merge_system_timestamp = 0L;
/*   29 */     this.merge_time_offset = 0L;
/*   30 */     this.is_data_available = false;
/*      */   }
/*      */   
/*      */   MergeCompensationInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.server_level_infos = new HashMap();
/*   37 */     this.is_data_available = false;
/*      */   }
/*      */   
/*      */   public MergeCompensationInfo()
/*      */   {
/*   42 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public MergeCompensationInfo(MergeCompensationInfo _o_)
/*      */   {
/*   47 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   MergeCompensationInfo(xbean.MergeCompensationInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   52 */     super(_xp_, _vn_);
/*   53 */     if ((_o1_ instanceof MergeCompensationInfo)) { assign((MergeCompensationInfo)_o1_);
/*   54 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   55 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   56 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(MergeCompensationInfo _o_) {
/*   61 */     _o_._xdb_verify_unsafe_();
/*   62 */     this.server_level_infos = new HashMap();
/*   63 */     for (Map.Entry<Long, xbean.ServerLevelInfo> _e_ : _o_.server_level_infos.entrySet())
/*   64 */       this.server_level_infos.put(_e_.getKey(), new ServerLevelInfo((xbean.ServerLevelInfo)_e_.getValue(), this, "server_level_infos"));
/*   65 */     this.max_server_level_zoneid = _o_.max_server_level_zoneid;
/*   66 */     this.merge_system_timestamp = _o_.merge_system_timestamp;
/*   67 */     this.merge_time_offset = _o_.merge_time_offset;
/*   68 */     this.is_data_available = _o_.is_data_available;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   73 */     this.server_level_infos = new HashMap();
/*   74 */     for (Map.Entry<Long, xbean.ServerLevelInfo> _e_ : _o_.server_level_infos.entrySet())
/*   75 */       this.server_level_infos.put(_e_.getKey(), new ServerLevelInfo((xbean.ServerLevelInfo)_e_.getValue(), this, "server_level_infos"));
/*   76 */     this.max_server_level_zoneid = _o_.max_server_level_zoneid;
/*   77 */     this.merge_system_timestamp = _o_.merge_system_timestamp;
/*   78 */     this.merge_time_offset = _o_.merge_time_offset;
/*   79 */     this.is_data_available = _o_.is_data_available;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   85 */     _xdb_verify_unsafe_();
/*   86 */     _os_.compact_uint32(this.server_level_infos.size());
/*   87 */     for (Map.Entry<Long, xbean.ServerLevelInfo> _e_ : this.server_level_infos.entrySet())
/*      */     {
/*   89 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*   90 */       ((xbean.ServerLevelInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*   92 */     _os_.marshal(this.max_server_level_zoneid);
/*   93 */     _os_.marshal(this.merge_system_timestamp);
/*   94 */     _os_.marshal(this.merge_time_offset);
/*   95 */     _os_.marshal(this.is_data_available);
/*   96 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  102 */     _xdb_verify_unsafe_();
/*      */     
/*  104 */     int size = _os_.uncompact_uint32();
/*  105 */     if (size >= 12)
/*      */     {
/*  107 */       this.server_level_infos = new HashMap(size * 2);
/*      */     }
/*  109 */     for (; size > 0; size--)
/*      */     {
/*  111 */       long _k_ = 0L;
/*  112 */       _k_ = _os_.unmarshal_long();
/*  113 */       xbean.ServerLevelInfo _v_ = new ServerLevelInfo(0, this, "server_level_infos");
/*  114 */       _v_.unmarshal(_os_);
/*  115 */       this.server_level_infos.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  118 */     this.max_server_level_zoneid = _os_.unmarshal_long();
/*  119 */     this.merge_system_timestamp = _os_.unmarshal_long();
/*  120 */     this.merge_time_offset = _os_.unmarshal_long();
/*  121 */     this.is_data_available = _os_.unmarshal_boolean();
/*  122 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  128 */     _xdb_verify_unsafe_();
/*  129 */     int _size_ = 0;
/*  130 */     for (Map.Entry<Long, xbean.ServerLevelInfo> _e_ : this.server_level_infos.entrySet())
/*      */     {
/*  132 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/*  133 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*      */     }
/*  135 */     _size_ += CodedOutputStream.computeInt64Size(2, this.max_server_level_zoneid);
/*  136 */     _size_ += CodedOutputStream.computeInt64Size(3, this.merge_system_timestamp);
/*  137 */     _size_ += CodedOutputStream.computeInt64Size(4, this.merge_time_offset);
/*  138 */     _size_ += CodedOutputStream.computeBoolSize(5, this.is_data_available);
/*  139 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  145 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  148 */       for (Map.Entry<Long, xbean.ServerLevelInfo> _e_ : this.server_level_infos.entrySet())
/*      */       {
/*  150 */         _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/*  151 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*      */       }
/*  153 */       _output_.writeInt64(2, this.max_server_level_zoneid);
/*  154 */       _output_.writeInt64(3, this.merge_system_timestamp);
/*  155 */       _output_.writeInt64(4, this.merge_time_offset);
/*  156 */       _output_.writeBool(5, this.is_data_available);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  160 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  162 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  168 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  171 */       boolean done = false;
/*  172 */       while (!done)
/*      */       {
/*  174 */         int tag = _input_.readTag();
/*  175 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  179 */           done = true;
/*  180 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  184 */           long _k_ = 0L;
/*  185 */           _k_ = _input_.readInt64();
/*  186 */           int readTag = _input_.readTag();
/*  187 */           if (10 != readTag)
/*      */           {
/*  189 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  191 */           xbean.ServerLevelInfo _v_ = new ServerLevelInfo(0, this, "server_level_infos");
/*  192 */           _input_.readMessage(_v_);
/*  193 */           this.server_level_infos.put(Long.valueOf(_k_), _v_);
/*  194 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  198 */           this.max_server_level_zoneid = _input_.readInt64();
/*  199 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  203 */           this.merge_system_timestamp = _input_.readInt64();
/*  204 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  208 */           this.merge_time_offset = _input_.readInt64();
/*  209 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  213 */           this.is_data_available = _input_.readBool();
/*  214 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  218 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  220 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  229 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  233 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  235 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MergeCompensationInfo copy()
/*      */   {
/*  241 */     _xdb_verify_unsafe_();
/*  242 */     return new MergeCompensationInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MergeCompensationInfo toData()
/*      */   {
/*  248 */     _xdb_verify_unsafe_();
/*  249 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MergeCompensationInfo toBean()
/*      */   {
/*  254 */     _xdb_verify_unsafe_();
/*  255 */     return new MergeCompensationInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MergeCompensationInfo toDataIf()
/*      */   {
/*  261 */     _xdb_verify_unsafe_();
/*  262 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MergeCompensationInfo toBeanIf()
/*      */   {
/*  267 */     _xdb_verify_unsafe_();
/*  268 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  274 */     _xdb_verify_unsafe_();
/*  275 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.ServerLevelInfo> getServer_level_infos()
/*      */   {
/*  282 */     _xdb_verify_unsafe_();
/*  283 */     return xdb.Logs.logMap(new LogKey(this, "server_level_infos"), this.server_level_infos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.ServerLevelInfo> getServer_level_infosAsData()
/*      */   {
/*  290 */     _xdb_verify_unsafe_();
/*      */     
/*  292 */     MergeCompensationInfo _o_ = this;
/*  293 */     Map<Long, xbean.ServerLevelInfo> server_level_infos = new HashMap();
/*  294 */     for (Map.Entry<Long, xbean.ServerLevelInfo> _e_ : _o_.server_level_infos.entrySet())
/*  295 */       server_level_infos.put(_e_.getKey(), new ServerLevelInfo.Data((xbean.ServerLevelInfo)_e_.getValue()));
/*  296 */     return server_level_infos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getMax_server_level_zoneid()
/*      */   {
/*  303 */     _xdb_verify_unsafe_();
/*  304 */     return this.max_server_level_zoneid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getMerge_system_timestamp()
/*      */   {
/*  311 */     _xdb_verify_unsafe_();
/*  312 */     return this.merge_system_timestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getMerge_time_offset()
/*      */   {
/*  319 */     _xdb_verify_unsafe_();
/*  320 */     return this.merge_time_offset;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIs_data_available()
/*      */   {
/*  327 */     _xdb_verify_unsafe_();
/*  328 */     return this.is_data_available;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMax_server_level_zoneid(long _v_)
/*      */   {
/*  335 */     _xdb_verify_unsafe_();
/*  336 */     xdb.Logs.logIf(new LogKey(this, "max_server_level_zoneid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  340 */         new xdb.logs.LogLong(this, MergeCompensationInfo.this.max_server_level_zoneid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  344 */             MergeCompensationInfo.this.max_server_level_zoneid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  348 */     });
/*  349 */     this.max_server_level_zoneid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMerge_system_timestamp(long _v_)
/*      */   {
/*  356 */     _xdb_verify_unsafe_();
/*  357 */     xdb.Logs.logIf(new LogKey(this, "merge_system_timestamp")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  361 */         new xdb.logs.LogLong(this, MergeCompensationInfo.this.merge_system_timestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  365 */             MergeCompensationInfo.this.merge_system_timestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  369 */     });
/*  370 */     this.merge_system_timestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMerge_time_offset(long _v_)
/*      */   {
/*  377 */     _xdb_verify_unsafe_();
/*  378 */     xdb.Logs.logIf(new LogKey(this, "merge_time_offset")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  382 */         new xdb.logs.LogLong(this, MergeCompensationInfo.this.merge_time_offset)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  386 */             MergeCompensationInfo.this.merge_time_offset = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  390 */     });
/*  391 */     this.merge_time_offset = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIs_data_available(boolean _v_)
/*      */   {
/*  398 */     _xdb_verify_unsafe_();
/*  399 */     xdb.Logs.logIf(new LogKey(this, "is_data_available")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  403 */         new xdb.logs.LogObject(this, Boolean.valueOf(MergeCompensationInfo.this.is_data_available))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  407 */             MergeCompensationInfo.this.is_data_available = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  411 */     });
/*  412 */     this.is_data_available = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  418 */     _xdb_verify_unsafe_();
/*  419 */     MergeCompensationInfo _o_ = null;
/*  420 */     if ((_o1_ instanceof MergeCompensationInfo)) { _o_ = (MergeCompensationInfo)_o1_;
/*  421 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  422 */       return false;
/*  423 */     if (!this.server_level_infos.equals(_o_.server_level_infos)) return false;
/*  424 */     if (this.max_server_level_zoneid != _o_.max_server_level_zoneid) return false;
/*  425 */     if (this.merge_system_timestamp != _o_.merge_system_timestamp) return false;
/*  426 */     if (this.merge_time_offset != _o_.merge_time_offset) return false;
/*  427 */     if (this.is_data_available != _o_.is_data_available) return false;
/*  428 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  434 */     _xdb_verify_unsafe_();
/*  435 */     int _h_ = 0;
/*  436 */     _h_ += this.server_level_infos.hashCode();
/*  437 */     _h_ = (int)(_h_ + this.max_server_level_zoneid);
/*  438 */     _h_ = (int)(_h_ + this.merge_system_timestamp);
/*  439 */     _h_ = (int)(_h_ + this.merge_time_offset);
/*  440 */     _h_ += (this.is_data_available ? 1231 : 1237);
/*  441 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  447 */     _xdb_verify_unsafe_();
/*  448 */     StringBuilder _sb_ = new StringBuilder();
/*  449 */     _sb_.append("(");
/*  450 */     _sb_.append(this.server_level_infos);
/*  451 */     _sb_.append(",");
/*  452 */     _sb_.append(this.max_server_level_zoneid);
/*  453 */     _sb_.append(",");
/*  454 */     _sb_.append(this.merge_system_timestamp);
/*  455 */     _sb_.append(",");
/*  456 */     _sb_.append(this.merge_time_offset);
/*  457 */     _sb_.append(",");
/*  458 */     _sb_.append(this.is_data_available);
/*  459 */     _sb_.append(")");
/*  460 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  466 */     ListenableBean lb = new ListenableBean();
/*  467 */     lb.add(new xdb.logs.ListenableMap().setVarName("server_level_infos"));
/*  468 */     lb.add(new ListenableChanged().setVarName("max_server_level_zoneid"));
/*  469 */     lb.add(new ListenableChanged().setVarName("merge_system_timestamp"));
/*  470 */     lb.add(new ListenableChanged().setVarName("merge_time_offset"));
/*  471 */     lb.add(new ListenableChanged().setVarName("is_data_available"));
/*  472 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.MergeCompensationInfo {
/*      */     private Const() {}
/*      */     
/*      */     MergeCompensationInfo nThis() {
/*  479 */       return MergeCompensationInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  485 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MergeCompensationInfo copy()
/*      */     {
/*  491 */       return MergeCompensationInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MergeCompensationInfo toData()
/*      */     {
/*  497 */       return MergeCompensationInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.MergeCompensationInfo toBean()
/*      */     {
/*  502 */       return MergeCompensationInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MergeCompensationInfo toDataIf()
/*      */     {
/*  508 */       return MergeCompensationInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.MergeCompensationInfo toBeanIf()
/*      */     {
/*  513 */       return MergeCompensationInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ServerLevelInfo> getServer_level_infos()
/*      */     {
/*  520 */       MergeCompensationInfo.this._xdb_verify_unsafe_();
/*  521 */       return xdb.Consts.constMap(MergeCompensationInfo.this.server_level_infos);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ServerLevelInfo> getServer_level_infosAsData()
/*      */     {
/*  528 */       MergeCompensationInfo.this._xdb_verify_unsafe_();
/*      */       
/*  530 */       MergeCompensationInfo _o_ = MergeCompensationInfo.this;
/*  531 */       Map<Long, xbean.ServerLevelInfo> server_level_infos = new HashMap();
/*  532 */       for (Map.Entry<Long, xbean.ServerLevelInfo> _e_ : _o_.server_level_infos.entrySet())
/*  533 */         server_level_infos.put(_e_.getKey(), new ServerLevelInfo.Data((xbean.ServerLevelInfo)_e_.getValue()));
/*  534 */       return server_level_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMax_server_level_zoneid()
/*      */     {
/*  541 */       MergeCompensationInfo.this._xdb_verify_unsafe_();
/*  542 */       return MergeCompensationInfo.this.max_server_level_zoneid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMerge_system_timestamp()
/*      */     {
/*  549 */       MergeCompensationInfo.this._xdb_verify_unsafe_();
/*  550 */       return MergeCompensationInfo.this.merge_system_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMerge_time_offset()
/*      */     {
/*  557 */       MergeCompensationInfo.this._xdb_verify_unsafe_();
/*  558 */       return MergeCompensationInfo.this.merge_time_offset;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_data_available()
/*      */     {
/*  565 */       MergeCompensationInfo.this._xdb_verify_unsafe_();
/*  566 */       return MergeCompensationInfo.this.is_data_available;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMax_server_level_zoneid(long _v_)
/*      */     {
/*  573 */       MergeCompensationInfo.this._xdb_verify_unsafe_();
/*  574 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMerge_system_timestamp(long _v_)
/*      */     {
/*  581 */       MergeCompensationInfo.this._xdb_verify_unsafe_();
/*  582 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMerge_time_offset(long _v_)
/*      */     {
/*  589 */       MergeCompensationInfo.this._xdb_verify_unsafe_();
/*  590 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_data_available(boolean _v_)
/*      */     {
/*  597 */       MergeCompensationInfo.this._xdb_verify_unsafe_();
/*  598 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  604 */       MergeCompensationInfo.this._xdb_verify_unsafe_();
/*  605 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  611 */       MergeCompensationInfo.this._xdb_verify_unsafe_();
/*  612 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  618 */       return MergeCompensationInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  624 */       return MergeCompensationInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  630 */       MergeCompensationInfo.this._xdb_verify_unsafe_();
/*  631 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  637 */       return MergeCompensationInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  643 */       return MergeCompensationInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  649 */       MergeCompensationInfo.this._xdb_verify_unsafe_();
/*  650 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  656 */       return MergeCompensationInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  662 */       return MergeCompensationInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  668 */       return MergeCompensationInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  674 */       return MergeCompensationInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  680 */       return MergeCompensationInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  686 */       return MergeCompensationInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  692 */       return MergeCompensationInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.MergeCompensationInfo
/*      */   {
/*      */     private HashMap<Long, xbean.ServerLevelInfo> server_level_infos;
/*      */     
/*      */     private long max_server_level_zoneid;
/*      */     
/*      */     private long merge_system_timestamp;
/*      */     
/*      */     private long merge_time_offset;
/*      */     
/*      */     private boolean is_data_available;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  712 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  717 */       this.server_level_infos = new HashMap();
/*  718 */       this.is_data_available = false;
/*      */     }
/*      */     
/*      */     Data(xbean.MergeCompensationInfo _o1_)
/*      */     {
/*  723 */       if ((_o1_ instanceof MergeCompensationInfo)) { assign((MergeCompensationInfo)_o1_);
/*  724 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  725 */       } else if ((_o1_ instanceof MergeCompensationInfo.Const)) assign(((MergeCompensationInfo.Const)_o1_).nThis()); else {
/*  726 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(MergeCompensationInfo _o_) {
/*  731 */       this.server_level_infos = new HashMap();
/*  732 */       for (Map.Entry<Long, xbean.ServerLevelInfo> _e_ : _o_.server_level_infos.entrySet())
/*  733 */         this.server_level_infos.put(_e_.getKey(), new ServerLevelInfo.Data((xbean.ServerLevelInfo)_e_.getValue()));
/*  734 */       this.max_server_level_zoneid = _o_.max_server_level_zoneid;
/*  735 */       this.merge_system_timestamp = _o_.merge_system_timestamp;
/*  736 */       this.merge_time_offset = _o_.merge_time_offset;
/*  737 */       this.is_data_available = _o_.is_data_available;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  742 */       this.server_level_infos = new HashMap();
/*  743 */       for (Map.Entry<Long, xbean.ServerLevelInfo> _e_ : _o_.server_level_infos.entrySet())
/*  744 */         this.server_level_infos.put(_e_.getKey(), new ServerLevelInfo.Data((xbean.ServerLevelInfo)_e_.getValue()));
/*  745 */       this.max_server_level_zoneid = _o_.max_server_level_zoneid;
/*  746 */       this.merge_system_timestamp = _o_.merge_system_timestamp;
/*  747 */       this.merge_time_offset = _o_.merge_time_offset;
/*  748 */       this.is_data_available = _o_.is_data_available;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  754 */       _os_.compact_uint32(this.server_level_infos.size());
/*  755 */       for (Map.Entry<Long, xbean.ServerLevelInfo> _e_ : this.server_level_infos.entrySet())
/*      */       {
/*  757 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  758 */         ((xbean.ServerLevelInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/*  760 */       _os_.marshal(this.max_server_level_zoneid);
/*  761 */       _os_.marshal(this.merge_system_timestamp);
/*  762 */       _os_.marshal(this.merge_time_offset);
/*  763 */       _os_.marshal(this.is_data_available);
/*  764 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  771 */       int size = _os_.uncompact_uint32();
/*  772 */       if (size >= 12)
/*      */       {
/*  774 */         this.server_level_infos = new HashMap(size * 2);
/*      */       }
/*  776 */       for (; size > 0; size--)
/*      */       {
/*  778 */         long _k_ = 0L;
/*  779 */         _k_ = _os_.unmarshal_long();
/*  780 */         xbean.ServerLevelInfo _v_ = xbean.Pod.newServerLevelInfoData();
/*  781 */         _v_.unmarshal(_os_);
/*  782 */         this.server_level_infos.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  785 */       this.max_server_level_zoneid = _os_.unmarshal_long();
/*  786 */       this.merge_system_timestamp = _os_.unmarshal_long();
/*  787 */       this.merge_time_offset = _os_.unmarshal_long();
/*  788 */       this.is_data_available = _os_.unmarshal_boolean();
/*  789 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  795 */       int _size_ = 0;
/*  796 */       for (Map.Entry<Long, xbean.ServerLevelInfo> _e_ : this.server_level_infos.entrySet())
/*      */       {
/*  798 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/*  799 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*      */       }
/*  801 */       _size_ += CodedOutputStream.computeInt64Size(2, this.max_server_level_zoneid);
/*  802 */       _size_ += CodedOutputStream.computeInt64Size(3, this.merge_system_timestamp);
/*  803 */       _size_ += CodedOutputStream.computeInt64Size(4, this.merge_time_offset);
/*  804 */       _size_ += CodedOutputStream.computeBoolSize(5, this.is_data_available);
/*  805 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  813 */         for (Map.Entry<Long, xbean.ServerLevelInfo> _e_ : this.server_level_infos.entrySet())
/*      */         {
/*  815 */           _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/*  816 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*      */         }
/*  818 */         _output_.writeInt64(2, this.max_server_level_zoneid);
/*  819 */         _output_.writeInt64(3, this.merge_system_timestamp);
/*  820 */         _output_.writeInt64(4, this.merge_time_offset);
/*  821 */         _output_.writeBool(5, this.is_data_available);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  825 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  827 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  835 */         boolean done = false;
/*  836 */         while (!done)
/*      */         {
/*  838 */           int tag = _input_.readTag();
/*  839 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  843 */             done = true;
/*  844 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  848 */             long _k_ = 0L;
/*  849 */             _k_ = _input_.readInt64();
/*  850 */             int readTag = _input_.readTag();
/*  851 */             if (10 != readTag)
/*      */             {
/*  853 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  855 */             xbean.ServerLevelInfo _v_ = xbean.Pod.newServerLevelInfoData();
/*  856 */             _input_.readMessage(_v_);
/*  857 */             this.server_level_infos.put(Long.valueOf(_k_), _v_);
/*  858 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  862 */             this.max_server_level_zoneid = _input_.readInt64();
/*  863 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  867 */             this.merge_system_timestamp = _input_.readInt64();
/*  868 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  872 */             this.merge_time_offset = _input_.readInt64();
/*  873 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  877 */             this.is_data_available = _input_.readBool();
/*  878 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  882 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  884 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  893 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  897 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  899 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MergeCompensationInfo copy()
/*      */     {
/*  905 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MergeCompensationInfo toData()
/*      */     {
/*  911 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.MergeCompensationInfo toBean()
/*      */     {
/*  916 */       return new MergeCompensationInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MergeCompensationInfo toDataIf()
/*      */     {
/*  922 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.MergeCompensationInfo toBeanIf()
/*      */     {
/*  927 */       return new MergeCompensationInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  933 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  937 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  941 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  945 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  949 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  953 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  957 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ServerLevelInfo> getServer_level_infos()
/*      */     {
/*  964 */       return this.server_level_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ServerLevelInfo> getServer_level_infosAsData()
/*      */     {
/*  971 */       return this.server_level_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMax_server_level_zoneid()
/*      */     {
/*  978 */       return this.max_server_level_zoneid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMerge_system_timestamp()
/*      */     {
/*  985 */       return this.merge_system_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMerge_time_offset()
/*      */     {
/*  992 */       return this.merge_time_offset;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_data_available()
/*      */     {
/*  999 */       return this.is_data_available;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMax_server_level_zoneid(long _v_)
/*      */     {
/* 1006 */       this.max_server_level_zoneid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMerge_system_timestamp(long _v_)
/*      */     {
/* 1013 */       this.merge_system_timestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMerge_time_offset(long _v_)
/*      */     {
/* 1020 */       this.merge_time_offset = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_data_available(boolean _v_)
/*      */     {
/* 1027 */       this.is_data_available = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1033 */       if (!(_o1_ instanceof Data)) return false;
/* 1034 */       Data _o_ = (Data)_o1_;
/* 1035 */       if (!this.server_level_infos.equals(_o_.server_level_infos)) return false;
/* 1036 */       if (this.max_server_level_zoneid != _o_.max_server_level_zoneid) return false;
/* 1037 */       if (this.merge_system_timestamp != _o_.merge_system_timestamp) return false;
/* 1038 */       if (this.merge_time_offset != _o_.merge_time_offset) return false;
/* 1039 */       if (this.is_data_available != _o_.is_data_available) return false;
/* 1040 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1046 */       int _h_ = 0;
/* 1047 */       _h_ += this.server_level_infos.hashCode();
/* 1048 */       _h_ = (int)(_h_ + this.max_server_level_zoneid);
/* 1049 */       _h_ = (int)(_h_ + this.merge_system_timestamp);
/* 1050 */       _h_ = (int)(_h_ + this.merge_time_offset);
/* 1051 */       _h_ += (this.is_data_available ? 1231 : 1237);
/* 1052 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1058 */       StringBuilder _sb_ = new StringBuilder();
/* 1059 */       _sb_.append("(");
/* 1060 */       _sb_.append(this.server_level_infos);
/* 1061 */       _sb_.append(",");
/* 1062 */       _sb_.append(this.max_server_level_zoneid);
/* 1063 */       _sb_.append(",");
/* 1064 */       _sb_.append(this.merge_system_timestamp);
/* 1065 */       _sb_.append(",");
/* 1066 */       _sb_.append(this.merge_time_offset);
/* 1067 */       _sb_.append(",");
/* 1068 */       _sb_.append(this.is_data_available);
/* 1069 */       _sb_.append(")");
/* 1070 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MergeCompensationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */